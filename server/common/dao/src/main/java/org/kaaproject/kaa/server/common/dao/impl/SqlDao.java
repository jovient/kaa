/*
 * Copyright 2014 CyberVision, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kaaproject.kaa.server.common.dao.impl;

import org.hibernate.LockOptions;

public interface SqlDao<T> extends Dao<T, String> {

    void refreshSession();
    /**
     * Save object. Will be returned object with id.
     *
     * @param o the domain object
     * @param flush specify if session flush needed.
     * @return the saved object
     */
    T save(T o, boolean flush);

    /**
     *
     * @param o the domain object
     * @param lockOptions
     */
    void lock(Object o, LockOptions lockOptions);
    /**
     * Find object by id.
     *
     * @param id   the id
     * @param lazy specifies whether return initialized object (if false is set)
     *             or proxy (if true is set)
     * @return the found object or null if object not found
     */
    T findById(String id, boolean lazy);

    /**
     * @param id
     * @param lazy
     * @param lockOptions
     * @return
     */
    T findById(String id, boolean lazy, LockOptions lockOptions);

    /**
     *
     * @param id
     * @param lockOptions
     * @return
     */
    T findById(String id, LockOptions lockOptions);

    /**
     * Persist model object
     *
     * @param o the model object
     * @return the persisted object
     */
    T persist(T o);
}
