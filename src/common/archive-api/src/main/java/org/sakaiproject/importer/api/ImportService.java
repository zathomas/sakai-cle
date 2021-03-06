/**********************************************************************************
 * $URL: https://source.sakaiproject.org/svn/common/trunk/archive-api/src/main/java/org/sakaiproject/importer/api/ImportService.java $
 * $Id: ImportService.java 106351 2012-03-28 20:21:21Z matthew@longsight.com $
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

package org.sakaiproject.importer.api;

import java.util.Collection;
import java.io.InputStream;

/**
 *  The ImportService provides a top level framework to handled import data collected from
 *  a content package or other archive.
 *
 */
public interface ImportService {

	/**
	 *  Check the validity of the file data passed.
	 *
	 *  @param archiveFileData is an input stream of data gathered from an archive file or package.
	 *  @return true if file data is valid.
	 */
	boolean isValidArchive(InputStream archiveFileData);

	/**
	 *  Parse the archive file data and create an Import Data Source object containing the results.
	 *
	 *	@param archiveFileData is an input stream of data gathered from an archive file or package.
	 *  @return ImportDataSource containing parsing results.
	 */
	ImportDataSource parseFromFile(InputStream archiveFileData);

	/**
	 *  doImportItems
	 *
	 *  @param importable a collection of things to import (?)
	 *  @param siteId is the the id of the site to import to.
	 */
	void doImportItems(Collection importables, String siteId);

}
