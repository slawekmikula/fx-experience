package org.comtel2000.keyboard.control;

/*******************************************************************************
 * Copyright (c) 2016 comtel2000
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted
 * provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions
 * and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of
 * conditions and the following disclaimer in the documentation and/or other materials provided with
 * the distribution.
 *
 * 3. Neither the name of the comtel2000 nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY
 * WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *******************************************************************************/

import java.nio.file.Path;
import java.util.Locale;

import org.comtel2000.keyboard.robot.IRobot;

import javafx.util.Builder;

public class KeyBoardBuilder implements Builder<KeyboardPane> {

  private final KeyboardPane kb;

  protected KeyBoardBuilder() {
    kb = new KeyboardPane();
  }

  public static KeyBoardBuilder create() {
    return new KeyBoardBuilder();
  }

  public KeyBoardBuilder scalingEnabled(boolean enabled) {
    kb.setScalingEnabled(enabled);
    return this;
  }

  public KeyBoardBuilder stickBottom(boolean enabled) {
    kb.setStickBottom(enabled);
    return this;
  }

  public KeyBoardBuilder layerPath(Path path) {
    kb.setLayerPath(path);
    return this;
  }

  public KeyBoardBuilder layer(DefaultLayer layer) {
    kb.setLayer(layer);
    return this;
  }

  public KeyBoardBuilder style(String css) {
    kb.setStyle(css);
    return this;
  }

  public KeyBoardBuilder initLocale(Locale locale) {
    kb.setLocale(locale);
    return this;
  }

  public KeyBoardBuilder initScale(double scale) {
    kb.setScale(scale);
    return this;
  }

  public KeyBoardBuilder addIRobot(IRobot robot) {
    kb.addRobotHandler(robot);
    return this;
  }

  @Override
  public KeyboardPane build() {
    try {
      kb.load();
    } catch (Exception e) {
      new RuntimeException(e);
    }
    return kb;
  }

}
