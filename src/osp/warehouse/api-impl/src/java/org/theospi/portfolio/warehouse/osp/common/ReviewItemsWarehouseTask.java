/**********************************************************************************
* $URL: https://source.sakaiproject.org/svn/osp/trunk/warehouse/api-impl/src/java/org/theospi/portfolio/warehouse/osp/common/ReviewItemsWarehouseTask.java $
* $Id: ReviewItemsWarehouseTask.java 105079 2012-02-24 23:08:11Z ottenhoff@longsight.com $
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

/**
 * 
 */
package org.theospi.portfolio.warehouse.osp.common;

import java.util.Collection;

import org.theospi.portfolio.review.mgt.ReviewManager;
import org.sakaiproject.warehouse.impl.BaseWarehouseTask;

/**
 * @author chrismaurer
 *
 */
public class ReviewItemsWarehouseTask extends BaseWarehouseTask {

   private ReviewManager reviewManager;
   
   protected Collection getItems() {
      Collection reviews = reviewManager.getReviews();
      return reviews;    
   }

   public ReviewManager getReviewManager() {
      return reviewManager;
   }

   public void setReviewManager(ReviewManager reviewManager) {
      this.reviewManager = reviewManager;
   }

}
