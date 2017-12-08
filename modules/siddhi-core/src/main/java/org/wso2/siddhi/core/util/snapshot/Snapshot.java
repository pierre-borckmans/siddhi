/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.siddhi.core.util.snapshot;

import org.wso2.siddhi.core.event.ComplexEvent;
import org.wso2.siddhi.core.event.stream.StreamEvent;

import java.io.Serializable;
import java.util.ArrayList;


public class Snapshot implements Serializable {
    public ArrayList<ComplexEvent> getAdditionsList() {
        return additionsList;
    }

    private ArrayList<ComplexEvent> additionsList;
    private StreamEvent firstEvent;
    private int numberOfDeletions;

    public Snapshot() {

    }

    public Snapshot(StreamEvent firstEvent) {
        this.firstEvent = firstEvent;
    }

    public <E extends ComplexEvent> Snapshot(StreamEvent first, ArrayList<ComplexEvent> additionsList,
                                             int numberOfDeletions) {
        this.firstEvent = first;
        this.additionsList = additionsList;
        this.numberOfDeletions = numberOfDeletions;
    }

    public Snapshot(ArrayList<ComplexEvent> additionsList, int numberOfDeletions) {
        this.additionsList = additionsList;
        this.numberOfDeletions = numberOfDeletions;
    }

    public StreamEvent getEnclosingStreamEvent(){
        return this.firstEvent;
    }

    public int getNumberOfDeletions() {
        return numberOfDeletions;
    }
}
