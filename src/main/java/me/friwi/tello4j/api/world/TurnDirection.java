/*
 * Copyright 2020 Fritz Windisch
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package me.friwi.tello4j.api.world;

/**
 * This enum represents all possible directions the drone can rotate
 *
 * @author Fritz Windisch
 */
public enum TurnDirection {
    LEFT("ccw"),
    RIGHT("cw");

    private String command;

    private TurnDirection(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}