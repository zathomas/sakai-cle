/**********************************************************************************
 * $URL: https://source.sakaiproject.org/svn/syllabus/trunk/syllabus-app/src/java/org/sakaiproject/jsf/syllabus/SyllabusIframeComponent.java $
 * $Id: SyllabusIframeComponent.java 105080 2012-02-24 23:10:31Z ottenhoff@longsight.com $
 ***********************************************************************************
 *
 * Copyright (c) 2003, 2004, 2005, 2006, 2008 The Sakai Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.opensource.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 **********************************************************************************/
package org.sakaiproject.jsf.syllabus;

import javax.faces.component.UIComponentBase;

public class SyllabusIframeComponent extends UIComponentBase
{
	public SyllabusIframeComponent()
	{
		super();
		this.setRendererType("SakaiSyllabusIframeRender");
	}

	public String getFamily()
	{
		return "SakaiSyllabusIframe";
	}
}



