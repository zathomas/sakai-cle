/**********************************************************************************
* $URL: https://source.sakaiproject.org/svn/osp/trunk/wizard/api/src/java/org/theospi/portfolio/wizard/model/EvaluationContentWrapperForWizard.java $
* $Id: EvaluationContentWrapperForWizard.java 105079 2012-02-24 23:08:11Z ottenhoff@longsight.com $
***********************************************************************************
*
 * Copyright (c) 2006, 2007, 2008 The Sakai Foundation
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

package org.theospi.portfolio.wizard.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.sakaiproject.metaobj.shared.model.Agent;
import org.sakaiproject.metaobj.shared.model.Id;
import org.sakaiproject.user.api.UserNotDefinedException;
import org.sakaiproject.user.cover.UserDirectoryService;
import org.theospi.portfolio.shared.model.EvaluationContentWrapper;

public class EvaluationContentWrapperForWizard extends EvaluationContentWrapper {

   public EvaluationContentWrapperForWizard(Id id, 
         String title, Agent owner, Date submittedDate, String siteId) throws UserNotDefinedException {
      
      super(id, title, owner, submittedDate, siteId);
		
      Set params = new HashSet();     
      if (owner != null && owner.getId() != null) {
         params.add(new ParamBean("session.WIZARD_USER_ID", getOwner().getId()));
         setUrl("openEvaluationWizardRedirect");
      }
      
      setEvalType(CompletedWizard.TYPE);
      
      params.add(new ParamBean("session.CURRENT_WIZARD_ID", getId().getValue()));
      
      setUrlParams(params);  
   }
   
}
