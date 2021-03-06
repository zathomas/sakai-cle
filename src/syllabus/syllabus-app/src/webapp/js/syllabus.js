var dragStartIndex;

function setupAccordion(iframId, isInstructor){
	var activeVar = false;
	if($( "#accordion .group" ).children("h3").size() == 1){
		//since there is only 1 option, might was well keep it open instead of collapsed
		activeVar = 0;
		//only one to expand, might as well hide the expand all link:
		$("#expandLink").hide();
	}
	$( "#accordion" ).accordion({ 
		header: "> div > h3",
		active: activeVar,
		autoHeight: false,
		collapsible: true,
		heightStyle: "content",
		activate: function( event, ui ) {
			mySetMainFrameHeight(iframId);
			if(ui.newHeader[0]){
				if($("#" + iframId, window.parent.document).parents('html, body').size() > 0){
					//we are in the portal, grab parent
					$("#" + iframId, window.parent.document).parents('html, body').animate({scrollTop: $(ui.newHeader[0]).offset().top});
				}else{
					//we are in tool view w/o portal, grab html/body
					$('html, body').animate({scrollTop: $(ui.newHeader[0]).offset().top});
				}
			}
		}
	});
	if(isInstructor){
		$( "#accordion" ).sortable({
			axis: "y",
			handle: "h3",
			start: function(event, ui){
			dragStartIndex = ui.item.index();
		},
		stop: function( event, ui ) {
			// IE doesn't register the blur when sorting
			// so trigger focusout handlers to remove .ui-state-focus
			ui.item.children( "h3" ).triggerHandler( "focusout" );

			//find how much this item was dragged:
			var dragEndIndex = ui.item.index();
			var moved = dragStartIndex - dragEndIndex;
			if(moved != 0){
				//update the position:
				$.ajax({
					type: 'POST',
					url: "/direct/syllabus/" + $(ui.item).attr("syllabusItem") + ".json",
					data: {"move": moved},
					async:false,
					failure: function failure(data){
						// TODO: internationalize
						alert("There was an error saving the order.");
					}
				});
			}
		}
		});
	}
	
	$( "#accordion div.group:first-child h3:first-child").focus();
}

// if the containing frame is small, then offsetHeight is pretty good for all but ie/xp.
// ie/xp reports clientHeight == offsetHeight, but has a good scrollHeight
function mySetMainFrameHeight(id)
{
	// run the script only if this window's name matches the id parameter
	// this tells us that the iframe in parent by the name of 'id' is the one who spawned us
	if (typeof window.name != "undefined" && id != window.name) return;

	var frame = parent.document.getElementById(id);
	if (frame)
	{

		var objToResize = (frame.style) ? frame.style : frame;

		var height; 
		
		var scrollH = document.body.scrollHeight;
		var offsetH = document.body.offsetHeight;
		var clientH = document.body.clientHeight;
		var innerDocScrollH = null;

		if (typeof(frame.contentDocument) != 'undefined' || typeof(frame.contentWindow) != 'undefined')
		{
			// very special way to get the height from IE on Windows!
			// note that the above special way of testing for undefined variables is necessary for older browsers
			// (IE 5.5 Mac) to not choke on the undefined variables.
 			var innerDoc = (frame.contentDocument) ? frame.contentDocument : frame.contentWindow.document;
			innerDocScrollH = (innerDoc != null) ? innerDoc.body.scrollHeight : null;
		}

		if (document.all && innerDocScrollH != null)
		{
			// IE on Windows only
			height = innerDocScrollH;
		}
		else
		{
			// every other browser!
			height = offsetH;
		}

		// here we fudge to get a little bigger
		//gsilver: changing this from 50 to 10, and adding extra bottom padding to the portletBody		
		var newHeight = height + 150;
		//contributed patch from hedrick@rutgers.edu (for very long documents)
		if (newHeight > 32760)
		newHeight = 32760;

		// no need to be smaller than...
		//if (height < 200) height = 200;
		objToResize.height=newHeight + "px";
	
		var s = " scrollH: " + scrollH + " offsetH: " + offsetH + " clientH: " + clientH + " innerDocScrollH: " + innerDocScrollH + " Read height: " + height + " Set height to: " + newHeight;

	}
}

function expandAccordion(iframId){
	$('.ui-accordion-content').show();
	mySetMainFrameHeight(iframId);
	$("#collapseLink").show();
	$("#expandLink").hide();
}

function collapseAccordion(iframId){
	$('.ui-accordion-content').hide();
	mySetMainFrameHeight(iframId);
	$("#collapseLink").hide();
	$("#expandLink").show();
}
