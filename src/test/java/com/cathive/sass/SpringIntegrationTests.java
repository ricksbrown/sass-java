/*
 * Copyright (C) 2014,2015 The Cat Hive Developers.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cathive.sass;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.nio.file.Paths;

import static org.junit.Assert.assertNotNull;

/**
 * @author Benjamin P. Jung
 */
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringIntegrationTests {

    @Autowired
    private SassService sassService;

    @Test
    public void testSassServiceFunctionality() {

        final String sassVersion = this.sassService.getLibsassVersion();
        assertNotNull("Could not determine the version of the native libsass implementation.", sassVersion);

        this.sassService.createContext(Paths.get("/bla/blubb/sdfsdf/sdfsjdfs"));


    }

    @Configuration
    @ComponentScan("com.cathive.sass")
    public static class UnitTestConfiguration {
        // TODO Provide javax.validation.Validator instance via @Bean annotation somehow.
    }

}
