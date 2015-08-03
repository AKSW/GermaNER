/*******************************************************************************
 * Copyright 2014
 * FG Language Technology
 * Technische Universität Darmstadt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package de.tu.darmstadt.lt.ner.preprocessing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ChangeColon
{

    public void normalize(String file1, String file2)
        throws FileNotFoundException, IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(file1));
        BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
        String input, output = null;
        while ((input = br.readLine()) != null) {
            if (input.contains(":")) {
                output = input.replaceAll(":", "__COLON__");
            }
            else {
                output = input;
            }
            bw.write(output + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public void deNormalize(String file1, String file2)
        throws FileNotFoundException, IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(file1));
        BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
        String input, output = null;
        while ((input = br.readLine()) != null) {
            if (input.contains("__COLON__")) {
                output = input.replaceAll("__COLON__", ":");
            }
            else {
                output = input;
            }
            bw.write(output + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}