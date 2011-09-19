/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.solder.test.util;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MavenArtifactPathResolverTest {
    public static final String groupId = "org.jboss.solder";
    public static final String artifactId = "seam-solder-api";

    public static final char linuxFileSeparator = '/';
    public static final char linuxPathSeparator = ':';

    public static final char windowsFileSeparator = '\\';
    public static final char windowsPathSeparator = ';';

    @Test
    public void testWindowsInLocalModule() {
        List<String> targetContents = Arrays.asList("V:\\workspace\\extensions\\impl\\target\\surefire-report", "V:\\workspace\\extensions\\impl\\target\\classes", "V:\\workspace\\extensions\\impl\\target\\test-classes", "V:\\workspace\\extensions\\impl\\target\\seam-solder-api-3.0.1-SNAPSHOT-sources.jar", "V:\\workspace\\extensions\\impl\\target\\seam-solder-api-3.0.1-SNAPSHOT.jar");

        MavenArtifactResolver resolver = new MavenArtifactResolver(groupId, artifactId, null, windowsPathSeparator, windowsFileSeparator);
        String path = resolver.scanForArtifact(targetContents);
        assertEquals("V:\\workspace\\extensions\\impl\\target\\seam-solder-api-3.0.1-SNAPSHOT.jar", path);
    }

    @Test
    public void testWindowsInLocalModuleWithDotQualifier() {
        List<String> targetContents = Arrays.asList("V:\\workspace\\extensions\\impl\\target\\surefire-report", "V:\\workspace\\extensions\\impl\\target\\classes", "V:\\workspace\\extensions\\impl\\target\\test-classes", "V:\\workspace\\extensions\\impl\\target\\seam-solder-api-3.0.1.Final-sources.jar", "V:\\workspace\\extensions\\impl\\target\\seam-solder-api-3.0.1.Final.jar");

        MavenArtifactResolver resolver = new MavenArtifactResolver(groupId, artifactId, null, windowsPathSeparator, windowsFileSeparator);
        String path = resolver.scanForArtifact(targetContents);
        assertEquals("V:\\workspace\\extensions\\impl\\target\\seam-solder-api-3.0.1.Final.jar", path);
    }


    @Test
    public void testLinuxInLocalModule() {
        List<String> targetContents = Arrays.asList("/workspace/extensions/impl/target/surefire-report", "/workspace/extensions/impl/target/classes", "/workspace/extensions/impl/target/test-classes", "/workspace/extensions/impl/target/seam-solder-api-3.0.1-SNAPSHOT-sources.jar", "/workspace/extensions/impl/target/seam-solder-api-3.0.1-SNAPSHOT.jar");

        MavenArtifactResolver resolver = new MavenArtifactResolver(groupId, artifactId, null, windowsPathSeparator, windowsFileSeparator);
        String path = resolver.scanForArtifact(targetContents);
        assertEquals("/workspace/extensions/impl/target/seam-solder-api-3.0.1-SNAPSHOT.jar", path);
    }

    @Test
    public void testLinuxInLocalModuleWithDotQualifier() {
        List<String> targetContents = Arrays.asList("/workspace/extensions/impl/target/surefire-report", "/workspace/extensions/impl/target/classes", "/workspace/extensions/impl/target/test-classes", "/workspace/extensions/impl/target/seam-solder-api-3.0.1.Final-sources.jar", "/workspace/extensions/impl/target/seam-solder-api-3.0.1.Final.jar");

        MavenArtifactResolver resolver = new MavenArtifactResolver(groupId, artifactId, null, windowsPathSeparator, windowsFileSeparator);
        String path = resolver.scanForArtifact(targetContents);
        assertEquals("/workspace/extensions/impl/target/seam-solder-api-3.0.1.Final.jar", path);
    }

    @Test
    public void testWindows() {
        String classPath = "V:\\workspace\\extensions\\impl\\target\\test-classes;V:\\workspace\\extensions\\impl\\target\\classes;C:\\Users\\john.doe\\.m2\\repository\\org\\javassist\\javassist\\3.13.0-GA\\javassist-3.13.0-GA.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\seam\\solder\\seam-solder-api\\3.0.1-SNAPSHOT\\seam-solder-api-3.0.1-SNAPSHOT.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\enterprise\\cdi-api\\1.0-SP2\\cdi-api-1.0-SP2.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\spec\\javax\\interceptor\\jboss-interceptors-api_1.1_spec\\1.0.0.Beta1\\jboss-interceptors-api_1.1_spec-1.0.0.Beta1.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\annotation\\jsr250-api\\1.0\\jsr250-api-1.0.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\inject\\javax.inject\\1\\javax.inject-1.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\slf4j\\slf4j-api\\1.5.10\\slf4j-api-1.5.10.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\weld\\weld-core\\1.1.0-SNAPSHOT\\weld-core-1.1.0-SNAPSHOT.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\weld\\weld-api\\1.1-SNAPSHOT\\weld-api-1.1-SNAPSHOT.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\weld\\weld-spi\\1.1-SNAPSHOT\\weld-spi-1.1-SNAPSHOT.jar;C:\\Users\\john.doe\\.m2\\repository\\com\\google\\guava\\guava\\r06\\guava-r06.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\interceptor\\jboss-interceptor\\1.0.0-CR11\\jboss-interceptor-1.0.0-CR11.jar;C:\\Users\\john.doe\\.m2\\repository\\javassist\\javassist\\3.11.0.GA\\javassist-3.11.0.GA.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\slf4j\\slf4j-ext\\1.5.10\\slf4j-ext-1.5.10.jar;C:\\Users\\john.doe\\.m2\\repository\\ch\\qos\\cal10n\\cal10n-api\\0.7.2\\cal10n-api-0.7.2.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\ejb3\\jboss-ejb3-api\\3.1.0\\jboss-ejb3-api-3.1.0.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\servlet\\servlet-api\\2.5\\servlet-api-2.5.jar;C:\\Users\\john.doe\\.m2\\repository\\junit\\junit\\4.8.1\\junit-4.8.1.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\arquillian\\arquillian-junit\\1.0.0.Alpha3\\arquillian-junit-1.0.0.Alpha3.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\arquillian\\arquillian-impl-base\\1.0.0.Alpha3\\arquillian-impl-base-1.0.0.Alpha3.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\arquillian\\arquillian-api\\1.0.0.Alpha3\\arquillian-api-1.0.0.Alpha3.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\shrinkwrap\\shrinkwrap-api\\1.0.0-alpha-11\\shrinkwrap-api-1.0.0-alpha-11.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\arquillian\\arquillian-spi\\1.0.0.Alpha3\\arquillian-spi-1.0.0.Alpha3.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\shrinkwrap\\shrinkwrap-impl-base\\1.0.0-alpha-11\\shrinkwrap-impl-base-1.0.0-alpha-11.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\shrinkwrap\\shrinkwrap-spi\\1.0.0-alpha-11\\shrinkwrap-spi-1.0.0-alpha-11.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\el\\el-api\\2.2\\el-api-2.2.jar;C:\\Users\\john.doe\\.m2\\repository\\el-impl\\el-impl\\1.0\\el-impl-1.0.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\arquillian\\container\\arquillian-weld-ee-embedded-1.1\\1.0.0.Alpha3\\arquillian-weld-ee-embedded-1.1-1.0.0.Alpha3.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\arquillian\\protocol\\arquillian-protocol-local\\1.0.0.Alpha3\\arquillian-protocol-local-1.0.0.Alpha3.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\arquillian\\testenricher\\arquillian-testenricher-cdi\\1.0.0.Alpha3\\arquillian-testenricher-cdi-1.0.0.Alpha3.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\shrinkwrap\\shrinkwrap-extension-classloader\\1.0.0-alpha-11\\shrinkwrap-extension-classloader-1.0.0-alpha-11.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\transaction\\jta\\1.1\\jta-1.1.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\persistence\\persistence-api\\1.0\\persistence-api-1.0.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\validation\\validation-api\\1.0.0.GA\\validation-api-1.0.0.GA.jar;/V:/eclipse/configuration/org.eclipse.osgi/bundles/311/1/.cp/;/V:/eclipse/configuration/org.eclipse.osgi/bundles/309/1/.cp/;/V:/eclipse/configuration/org.eclipse.osgi/bundles/310/1/.cp/";

        MavenArtifactResolver resolver = new MavenArtifactResolver(groupId, artifactId, classPath, windowsPathSeparator, windowsFileSeparator);
        String path = resolver.resolve();
        assertEquals("C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\seam\\solder\\seam-solder-api\\3.0.1-SNAPSHOT\\seam-solder-api-3.0.1-SNAPSHOT.jar", path);
    }

    @Test
    public void testWindowsInReactorWithDotQualifier() {
        String classPath = "V:\\workspace\\extensions\\impl\\target\\test-classes;V:\\workspace\\extensions\\impl\\target\\classes;V:\\workspace\\extensions\\impl\\target\\seam-solder-api-3.0.1.Final.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\javassist\\javassist\\3.13.0-GA\\javassist-3.13.0-GA.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\enterprise\\cdi-api\\1.0-SP2\\cdi-api-1.0-SP2.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\spec\\javax\\interceptor\\jboss-interceptors-api_1.1_spec\\1.0.0.Beta1\\jboss-interceptors-api_1.1_spec-1.0.0.Beta1.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\annotation\\jsr250-api\\1.0\\jsr250-api-1.0.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\inject\\javax.inject\\1\\javax.inject-1.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\slf4j\\slf4j-api\\1.5.10\\slf4j-api-1.5.10.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\weld\\weld-core\\1.1.0-SNAPSHOT\\weld-core-1.1.0-SNAPSHOT.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\weld\\weld-api\\1.1-SNAPSHOT\\weld-api-1.1-SNAPSHOT.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\weld\\weld-spi\\1.1-SNAPSHOT\\weld-spi-1.1-SNAPSHOT.jar;C:\\Users\\john.doe\\.m2\\repository\\com\\google\\guava\\guava\\r06\\guava-r06.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\interceptor\\jboss-interceptor\\1.0.0-CR11\\jboss-interceptor-1.0.0-CR11.jar;C:\\Users\\john.doe\\.m2\\repository\\javassist\\javassist\\3.11.0.GA\\javassist-3.11.0.GA.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\slf4j\\slf4j-ext\\1.5.10\\slf4j-ext-1.5.10.jar;C:\\Users\\john.doe\\.m2\\repository\\ch\\qos\\cal10n\\cal10n-api\\0.7.2\\cal10n-api-0.7.2.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\ejb3\\jboss-ejb3-api\\3.1.0\\jboss-ejb3-api-3.1.0.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\servlet\\servlet-api\\2.5\\servlet-api-2.5.jar;C:\\Users\\john.doe\\.m2\\repository\\junit\\junit\\4.8.1\\junit-4.8.1.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\arquillian\\arquillian-junit\\1.0.0.Alpha3\\arquillian-junit-1.0.0.Alpha3.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\arquillian\\arquillian-impl-base\\1.0.0.Alpha3\\arquillian-impl-base-1.0.0.Alpha3.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\arquillian\\arquillian-api\\1.0.0.Alpha3\\arquillian-api-1.0.0.Alpha3.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\shrinkwrap\\shrinkwrap-api\\1.0.0-alpha-11\\shrinkwrap-api-1.0.0-alpha-11.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\arquillian\\arquillian-spi\\1.0.0.Alpha3\\arquillian-spi-1.0.0.Alpha3.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\shrinkwrap\\shrinkwrap-impl-base\\1.0.0-alpha-11\\shrinkwrap-impl-base-1.0.0-alpha-11.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\shrinkwrap\\shrinkwrap-spi\\1.0.0-alpha-11\\shrinkwrap-spi-1.0.0-alpha-11.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\el\\el-api\\2.2\\el-api-2.2.jar;C:\\Users\\john.doe\\.m2\\repository\\el-impl\\el-impl\\1.0\\el-impl-1.0.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\arquillian\\container\\arquillian-weld-ee-embedded-1.1\\1.0.0.Alpha3\\arquillian-weld-ee-embedded-1.1-1.0.0.Alpha3.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\arquillian\\protocol\\arquillian-protocol-local\\1.0.0.Alpha3\\arquillian-protocol-local-1.0.0.Alpha3.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\arquillian\\testenricher\\arquillian-testenricher-cdi\\1.0.0.Alpha3\\arquillian-testenricher-cdi-1.0.0.Alpha3.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\shrinkwrap\\shrinkwrap-extension-classloader\\1.0.0-alpha-11\\shrinkwrap-extension-classloader-1.0.0-alpha-11.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\transaction\\jta\\1.1\\jta-1.1.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\persistence\\persistence-api\\1.0\\persistence-api-1.0.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\validation\\validation-api\\1.0.0.GA\\validation-api-1.0.0.GA.jar;/V:/eclipse/configuration/org.eclipse.osgi/bundles/311/1/.cp/;/V:/eclipse/configuration/org.eclipse.osgi/bundles/309/1/.cp/;/V:/eclipse/configuration/org.eclipse.osgi/bundles/310/1/.cp/";

        MavenArtifactResolver resolver = new MavenArtifactResolver(groupId, artifactId, classPath, windowsPathSeparator, windowsFileSeparator);
        String path = resolver.resolve();
        assertEquals("V:\\workspace\\extensions\\impl\\target\\seam-solder-api-3.0.1.Final.jar", path);
    }

    @Test
    public void testWindowsWithDotQualifier() {
        String classPath = "V:\\workspace\\extensions\\impl\\target\\test-classes;V:\\workspace\\extensions\\impl\\target\\classes;C:\\Users\\john.doe\\.m2\\repository\\org\\javassist\\javassist\\3.13.0-GA\\javassist-3.13.0-GA.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\seam\\solder\\seam-solder-api\\3.0.1.Final\\seam-solder-api-3.0.1.Final.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\enterprise\\cdi-api\\1.0-SP2\\cdi-api-1.0-SP2.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\spec\\javax\\interceptor\\jboss-interceptors-api_1.1_spec\\1.0.0.Beta1\\jboss-interceptors-api_1.1_spec-1.0.0.Beta1.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\annotation\\jsr250-api\\1.0\\jsr250-api-1.0.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\inject\\javax.inject\\1\\javax.inject-1.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\slf4j\\slf4j-api\\1.5.10\\slf4j-api-1.5.10.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\weld\\weld-core\\1.1.0-SNAPSHOT\\weld-core-1.1.0-SNAPSHOT.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\weld\\weld-api\\1.1-SNAPSHOT\\weld-api-1.1-SNAPSHOT.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\weld\\weld-spi\\1.1-SNAPSHOT\\weld-spi-1.1-SNAPSHOT.jar;C:\\Users\\john.doe\\.m2\\repository\\com\\google\\guava\\guava\\r06\\guava-r06.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\interceptor\\jboss-interceptor\\1.0.0-CR11\\jboss-interceptor-1.0.0-CR11.jar;C:\\Users\\john.doe\\.m2\\repository\\javassist\\javassist\\3.11.0.GA\\javassist-3.11.0.GA.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\slf4j\\slf4j-ext\\1.5.10\\slf4j-ext-1.5.10.jar;C:\\Users\\john.doe\\.m2\\repository\\ch\\qos\\cal10n\\cal10n-api\\0.7.2\\cal10n-api-0.7.2.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\ejb3\\jboss-ejb3-api\\3.1.0\\jboss-ejb3-api-3.1.0.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\servlet\\servlet-api\\2.5\\servlet-api-2.5.jar;C:\\Users\\john.doe\\.m2\\repository\\junit\\junit\\4.8.1\\junit-4.8.1.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\arquillian\\arquillian-junit\\1.0.0.Alpha3\\arquillian-junit-1.0.0.Alpha3.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\arquillian\\arquillian-impl-base\\1.0.0.Alpha3\\arquillian-impl-base-1.0.0.Alpha3.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\arquillian\\arquillian-api\\1.0.0.Alpha3\\arquillian-api-1.0.0.Alpha3.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\shrinkwrap\\shrinkwrap-api\\1.0.0-alpha-11\\shrinkwrap-api-1.0.0-alpha-11.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\arquillian\\arquillian-spi\\1.0.0.Alpha3\\arquillian-spi-1.0.0.Alpha3.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\shrinkwrap\\shrinkwrap-impl-base\\1.0.0-alpha-11\\shrinkwrap-impl-base-1.0.0-alpha-11.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\shrinkwrap\\shrinkwrap-spi\\1.0.0-alpha-11\\shrinkwrap-spi-1.0.0-alpha-11.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\el\\el-api\\2.2\\el-api-2.2.jar;C:\\Users\\john.doe\\.m2\\repository\\el-impl\\el-impl\\1.0\\el-impl-1.0.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\arquillian\\container\\arquillian-weld-ee-embedded-1.1\\1.0.0.Alpha3\\arquillian-weld-ee-embedded-1.1-1.0.0.Alpha3.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\arquillian\\protocol\\arquillian-protocol-local\\1.0.0.Alpha3\\arquillian-protocol-local-1.0.0.Alpha3.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\arquillian\\testenricher\\arquillian-testenricher-cdi\\1.0.0.Alpha3\\arquillian-testenricher-cdi-1.0.0.Alpha3.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\shrinkwrap\\shrinkwrap-extension-classloader\\1.0.0-alpha-11\\shrinkwrap-extension-classloader-1.0.0-alpha-11.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\transaction\\jta\\1.1\\jta-1.1.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\persistence\\persistence-api\\1.0\\persistence-api-1.0.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\validation\\validation-api\\1.0.0.GA\\validation-api-1.0.0.GA.jar;/V:/eclipse/configuration/org.eclipse.osgi/bundles/311/1/.cp/;/V:/eclipse/configuration/org.eclipse.osgi/bundles/309/1/.cp/;/V:/eclipse/configuration/org.eclipse.osgi/bundles/310/1/.cp/";

        MavenArtifactResolver resolver = new MavenArtifactResolver(groupId, artifactId, classPath, windowsPathSeparator, windowsFileSeparator);
        String path = resolver.resolve();
        assertEquals("C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\seam\\solder\\seam-solder-api\\3.0.1.Final\\seam-solder-api-3.0.1.Final.jar", path);
    }

    @Test
    public void testWindowsInReactor() {
        String classPath = "V:\\workspace\\extensions\\impl\\target\\test-classes;V:\\workspace\\extensions\\impl\\target\\classes;V:\\workspace\\extensions\\impl\\target\\seam-solder-api-3.0.1-SNAPSHOT.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\javassist\\javassist\\3.13.0-GA\\javassist-3.13.0-GA.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\enterprise\\cdi-api\\1.0-SP2\\cdi-api-1.0-SP2.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\spec\\javax\\interceptor\\jboss-interceptors-api_1.1_spec\\1.0.0.Beta1\\jboss-interceptors-api_1.1_spec-1.0.0.Beta1.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\annotation\\jsr250-api\\1.0\\jsr250-api-1.0.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\inject\\javax.inject\\1\\javax.inject-1.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\slf4j\\slf4j-api\\1.5.10\\slf4j-api-1.5.10.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\weld\\weld-core\\1.1.0-SNAPSHOT\\weld-core-1.1.0-SNAPSHOT.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\weld\\weld-api\\1.1-SNAPSHOT\\weld-api-1.1-SNAPSHOT.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\weld\\weld-spi\\1.1-SNAPSHOT\\weld-spi-1.1-SNAPSHOT.jar;C:\\Users\\john.doe\\.m2\\repository\\com\\google\\guava\\guava\\r06\\guava-r06.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\interceptor\\jboss-interceptor\\1.0.0-CR11\\jboss-interceptor-1.0.0-CR11.jar;C:\\Users\\john.doe\\.m2\\repository\\javassist\\javassist\\3.11.0.GA\\javassist-3.11.0.GA.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\slf4j\\slf4j-ext\\1.5.10\\slf4j-ext-1.5.10.jar;C:\\Users\\john.doe\\.m2\\repository\\ch\\qos\\cal10n\\cal10n-api\\0.7.2\\cal10n-api-0.7.2.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\ejb3\\jboss-ejb3-api\\3.1.0\\jboss-ejb3-api-3.1.0.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\servlet\\servlet-api\\2.5\\servlet-api-2.5.jar;C:\\Users\\john.doe\\.m2\\repository\\junit\\junit\\4.8.1\\junit-4.8.1.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\arquillian\\arquillian-junit\\1.0.0.Alpha3\\arquillian-junit-1.0.0.Alpha3.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\arquillian\\arquillian-impl-base\\1.0.0.Alpha3\\arquillian-impl-base-1.0.0.Alpha3.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\arquillian\\arquillian-api\\1.0.0.Alpha3\\arquillian-api-1.0.0.Alpha3.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\shrinkwrap\\shrinkwrap-api\\1.0.0-alpha-11\\shrinkwrap-api-1.0.0-alpha-11.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\arquillian\\arquillian-spi\\1.0.0.Alpha3\\arquillian-spi-1.0.0.Alpha3.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\shrinkwrap\\shrinkwrap-impl-base\\1.0.0-alpha-11\\shrinkwrap-impl-base-1.0.0-alpha-11.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\shrinkwrap\\shrinkwrap-spi\\1.0.0-alpha-11\\shrinkwrap-spi-1.0.0-alpha-11.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\el\\el-api\\2.2\\el-api-2.2.jar;C:\\Users\\john.doe\\.m2\\repository\\el-impl\\el-impl\\1.0\\el-impl-1.0.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\arquillian\\container\\arquillian-weld-ee-embedded-1.1\\1.0.0.Alpha3\\arquillian-weld-ee-embedded-1.1-1.0.0.Alpha3.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\arquillian\\protocol\\arquillian-protocol-local\\1.0.0.Alpha3\\arquillian-protocol-local-1.0.0.Alpha3.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\arquillian\\testenricher\\arquillian-testenricher-cdi\\1.0.0.Alpha3\\arquillian-testenricher-cdi-1.0.0.Alpha3.jar;C:\\Users\\john.doe\\.m2\\repository\\org\\jboss\\shrinkwrap\\shrinkwrap-extension-classloader\\1.0.0-alpha-11\\shrinkwrap-extension-classloader-1.0.0-alpha-11.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\transaction\\jta\\1.1\\jta-1.1.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\persistence\\persistence-api\\1.0\\persistence-api-1.0.jar;C:\\Users\\john.doe\\.m2\\repository\\javax\\validation\\validation-api\\1.0.0.GA\\validation-api-1.0.0.GA.jar;/V:/eclipse/configuration/org.eclipse.osgi/bundles/311/1/.cp/;/V:/eclipse/configuration/org.eclipse.osgi/bundles/309/1/.cp/;/V:/eclipse/configuration/org.eclipse.osgi/bundles/310/1/.cp/";

        MavenArtifactResolver resolver = new MavenArtifactResolver(groupId, artifactId, classPath, windowsPathSeparator, windowsFileSeparator);
        String path = resolver.resolve();
        assertEquals("V:\\workspace\\extensions\\impl\\target\\seam-solder-api-3.0.1-SNAPSHOT.jar", path);
    }

    @Test
    public void testLinux() {
        String classPath = "/home/user/workspace/extensions/impl/target/test-classes:/home/jdoe/workspace/extensions/impl/target/classes:/home/jdoe/.m2/repository/org/javassist/javassist/3.13.0-GA/javassist-3.13.0-GA.jar:/home/jdoe/.m2/repository/org/jboss/seam/solder/seam-solder-api/3.0.1-SNAPSHOT/seam-solder-api-3.0.1-SNAPSHOT.jar:/home/jdoe/.m2/repository/javax/enterprise/cdi-api/1.0-SP2/cdi-api-1.0-SP2.jar:/home/jdoe/.m2/repository/org/jboss/spec/javax/interceptor/jboss-interceptors-api_1.1_spec/1.0.0.Beta1/jboss-interceptors-api_1.1_spec-1.0.0.Beta1.jar:/home/jdoe/.m2/repository/javax/annotation/jsr250-api/1.0/jsr250-api-1.0.jar:/home/jdoe/.m2/repository/javax/inject/javax.inject/1/javax.inject-1.jar:/home/jdoe/.m2/repository/org/slf4j/slf4j-api/1.5.10/slf4j-api-1.5.10.jar:/home/jdoe/.m2/repository/org/jboss/weld/weld-core/1.1.0-SNAPSHOT/weld-core-1.1.0-SNAPSHOT.jar:/home/jdoe/.m2/repository/org/jboss/weld/weld-api/1.1-SNAPSHOT/weld-api-1.1-SNAPSHOT.jar:/home/jdoe/.m2/repository/org/jboss/weld/weld-spi/1.1-SNAPSHOT/weld-spi-1.1-SNAPSHOT.jar:/home/jdoe/.m2/repository/com/google/guava/guava/r06/guava-r06.jar:/home/jdoe/.m2/repository/org/jboss/interceptor/jboss-interceptor/1.0.0-CR11/jboss-interceptor-1.0.0-CR11.jar:/home/jdoe/.m2/repository/javassist/javassist/3.11.0.GA/javassist-3.11.0.GA.jar:/home/jdoe/.m2/repository/org/slf4j/slf4j-ext/1.5.10/slf4j-ext-1.5.10.jar:/home/jdoe/.m2/repository/ch/qos/cal10n/cal10n-api/0.7.2/cal10n-api-0.7.2.jar:/home/jdoe/.m2/repository/org/jboss/ejb3/jboss-ejb3-api/3.1.0/jboss-ejb3-api-3.1.0.jar:/home/jdoe/.m2/repository/javax/servlet/servlet-api/2.5/servlet-api-2.5.jar:/home/jdoe/.m2/repository/junit/junit/4.8.1/junit-4.8.1.jar:/home/jdoe/.m2/repository/org/jboss/arquillian/arquillian-junit/1.0.0.Alpha3/arquillian-junit-1.0.0.Alpha3.jar:/home/jdoe/.m2/repository/org/jboss/arquillian/arquillian-impl-base/1.0.0.Alpha3/arquillian-impl-base-1.0.0.Alpha3.jar:/home/jdoe/.m2/repository/org/jboss/arquillian/arquillian-api/1.0.0.Alpha3/arquillian-api-1.0.0.Alpha3.jar:/home/jdoe/.m2/repository/org/jboss/shrinkwrap/shrinkwrap-api/1.0.0-alpha-11/shrinkwrap-api-1.0.0-alpha-11.jar:/home/jdoe/.m2/repository/org/jboss/arquillian/arquillian-spi/1.0.0.Alpha3/arquillian-spi-1.0.0.Alpha3.jar:/home/jdoe/.m2/repository/org/jboss/shrinkwrap/shrinkwrap-impl-base/1.0.0-alpha-11/shrinkwrap-impl-base-1.0.0-alpha-11.jar:/home/jdoe/.m2/repository/org/jboss/shrinkwrap/shrinkwrap-spi/1.0.0-alpha-11/shrinkwrap-spi-1.0.0-alpha-11.jar:/home/jdoe/.m2/repository/javax/el/el-api/2.2/el-api-2.2.jar:/home/jdoe/.m2/repository/el-impl/el-impl/1.0/el-impl-1.0.jar:/home/jdoe/.m2/repository/org/jboss/arquillian/container/arquillian-weld-ee-embedded-1.1/1.0.0.Alpha3/arquillian-weld-ee-embedded-1.1-1.0.0.Alpha3.jar:/home/jdoe/.m2/repository/org/jboss/arquillian/protocol/arquillian-protocol-local/1.0.0.Alpha3/arquillian-protocol-local-1.0.0.Alpha3.jar:/home/jdoe/.m2/repository/org/jboss/arquillian/testenricher/arquillian-testenricher-cdi/1.0.0.Alpha3/arquillian-testenricher-cdi-1.0.0.Alpha3.jar:/home/jdoe/.m2/repository/org/jboss/shrinkwrap/shrinkwrap-extension-classloader/1.0.0-alpha-11/shrinkwrap-extension-classloader-1.0.0-alpha-11.jar:/home/jdoe/.m2/repository/javax/transaction/jta/1.1/jta-1.1.jar:/home/jdoe/.m2/repository/javax/persistence/persistence-api/1.0/persistence-api-1.0.jar:/home/jdoe/.m2/repository/javax/validation/validation-api/1.0.0.GA/validation-api-1.0.0.GA.jar:/home/jdoe/.eclipse/org.eclipse.platform_3.5.0_155965261/configuration/org.eclipse.osgi/bundles/112/1/.cp/:/home/jdoe/.eclipse/org.eclipse.platform_3.5.0_155965261/configuration/org.eclipse.osgi/bundles/110/1/.cp/:/home/jdoe/.eclipse/org.eclipse.platform_3.5.0_155965261/configuration/org.eclipse.osgi/bundles/111/1/.cp/";

        MavenArtifactResolver resolver = new MavenArtifactResolver(groupId, artifactId, classPath, linuxPathSeparator, linuxFileSeparator);
        String path = resolver.resolve();
        assertEquals("/home/jdoe/.m2/repository/org/jboss/seam/solder/seam-solder-api/3.0.1-SNAPSHOT/seam-solder-api-3.0.1-SNAPSHOT.jar", path);
    }

    @Test
    public void testLinuxWithDotQualifier() {
        String classPath = "/home/user/workspace/extensions/impl/target/test-classes:/home/jdoe/workspace/extensions/impl/target/classes:/home/jdoe/.m2/repository/org/javassist/javassist/3.13.0-GA/javassist-3.13.0-GA.jar:/home/jdoe/.m2/repository/org/jboss/seam/solder/seam-solder-api/3.0.1.Final/seam-solder-api-3.0.1.Final.jar:/home/jdoe/.m2/repository/javax/enterprise/cdi-api/1.0-SP2/cdi-api-1.0-SP2.jar:/home/jdoe/.m2/repository/org/jboss/spec/javax/interceptor/jboss-interceptors-api_1.1_spec/1.0.0.Beta1/jboss-interceptors-api_1.1_spec-1.0.0.Beta1.jar:/home/jdoe/.m2/repository/javax/annotation/jsr250-api/1.0/jsr250-api-1.0.jar:/home/jdoe/.m2/repository/javax/inject/javax.inject/1/javax.inject-1.jar:/home/jdoe/.m2/repository/org/slf4j/slf4j-api/1.5.10/slf4j-api-1.5.10.jar:/home/jdoe/.m2/repository/org/jboss/weld/weld-core/1.1.0-SNAPSHOT/weld-core-1.1.0-SNAPSHOT.jar:/home/jdoe/.m2/repository/org/jboss/weld/weld-api/1.1-SNAPSHOT/weld-api-1.1-SNAPSHOT.jar:/home/jdoe/.m2/repository/org/jboss/weld/weld-spi/1.1-SNAPSHOT/weld-spi-1.1-SNAPSHOT.jar:/home/jdoe/.m2/repository/com/google/guava/guava/r06/guava-r06.jar:/home/jdoe/.m2/repository/org/jboss/interceptor/jboss-interceptor/1.0.0-CR11/jboss-interceptor-1.0.0-CR11.jar:/home/jdoe/.m2/repository/javassist/javassist/3.11.0.GA/javassist-3.11.0.GA.jar:/home/jdoe/.m2/repository/org/slf4j/slf4j-ext/1.5.10/slf4j-ext-1.5.10.jar:/home/jdoe/.m2/repository/ch/qos/cal10n/cal10n-api/0.7.2/cal10n-api-0.7.2.jar:/home/jdoe/.m2/repository/org/jboss/ejb3/jboss-ejb3-api/3.1.0/jboss-ejb3-api-3.1.0.jar:/home/jdoe/.m2/repository/javax/servlet/servlet-api/2.5/servlet-api-2.5.jar:/home/jdoe/.m2/repository/junit/junit/4.8.1/junit-4.8.1.jar:/home/jdoe/.m2/repository/org/jboss/arquillian/arquillian-junit/1.0.0.Alpha3/arquillian-junit-1.0.0.Alpha3.jar:/home/jdoe/.m2/repository/org/jboss/arquillian/arquillian-impl-base/1.0.0.Alpha3/arquillian-impl-base-1.0.0.Alpha3.jar:/home/jdoe/.m2/repository/org/jboss/arquillian/arquillian-api/1.0.0.Alpha3/arquillian-api-1.0.0.Alpha3.jar:/home/jdoe/.m2/repository/org/jboss/shrinkwrap/shrinkwrap-api/1.0.0-alpha-11/shrinkwrap-api-1.0.0-alpha-11.jar:/home/jdoe/.m2/repository/org/jboss/arquillian/arquillian-spi/1.0.0.Alpha3/arquillian-spi-1.0.0.Alpha3.jar:/home/jdoe/.m2/repository/org/jboss/shrinkwrap/shrinkwrap-impl-base/1.0.0-alpha-11/shrinkwrap-impl-base-1.0.0-alpha-11.jar:/home/jdoe/.m2/repository/org/jboss/shrinkwrap/shrinkwrap-spi/1.0.0-alpha-11/shrinkwrap-spi-1.0.0-alpha-11.jar:/home/jdoe/.m2/repository/javax/el/el-api/2.2/el-api-2.2.jar:/home/jdoe/.m2/repository/el-impl/el-impl/1.0/el-impl-1.0.jar:/home/jdoe/.m2/repository/org/jboss/arquillian/container/arquillian-weld-ee-embedded-1.1/1.0.0.Alpha3/arquillian-weld-ee-embedded-1.1-1.0.0.Alpha3.jar:/home/jdoe/.m2/repository/org/jboss/arquillian/protocol/arquillian-protocol-local/1.0.0.Alpha3/arquillian-protocol-local-1.0.0.Alpha3.jar:/home/jdoe/.m2/repository/org/jboss/arquillian/testenricher/arquillian-testenricher-cdi/1.0.0.Alpha3/arquillian-testenricher-cdi-1.0.0.Alpha3.jar:/home/jdoe/.m2/repository/org/jboss/shrinkwrap/shrinkwrap-extension-classloader/1.0.0-alpha-11/shrinkwrap-extension-classloader-1.0.0-alpha-11.jar:/home/jdoe/.m2/repository/javax/transaction/jta/1.1/jta-1.1.jar:/home/jdoe/.m2/repository/javax/persistence/persistence-api/1.0/persistence-api-1.0.jar:/home/jdoe/.m2/repository/javax/validation/validation-api/1.0.0.GA/validation-api-1.0.0.GA.jar:/home/jdoe/.eclipse/org.eclipse.platform_3.5.0_155965261/configuration/org.eclipse.osgi/bundles/112/1/.cp/:/home/jdoe/.eclipse/org.eclipse.platform_3.5.0_155965261/configuration/org.eclipse.osgi/bundles/110/1/.cp/:/home/jdoe/.eclipse/org.eclipse.platform_3.5.0_155965261/configuration/org.eclipse.osgi/bundles/111/1/.cp/";

        MavenArtifactResolver resolver = new MavenArtifactResolver(groupId, artifactId, classPath, linuxPathSeparator, linuxFileSeparator);
        String path = resolver.resolve();
        assertEquals("/home/jdoe/.m2/repository/org/jboss/seam/solder/seam-solder-api/3.0.1.Final/seam-solder-api-3.0.1.Final.jar", path);
    }

    @Test
    public void testLinuxInReactor() {
        String classPath = "/home/user/workspace/extensions/impl/target/test-classes:/home/jdoe/workspace/extensions/impl/target/classes:/home/jdoe/workspace/extensions/impl/target/seam-solder-api-3.0.1-SNAPSHOT.jar:/home/jdoe/.m2/repository/org/javassist/javassist/3.13.0-GA/javassist-3.13.0-GA.jar:/home/jdoe/.m2/repository/javax/enterprise/cdi-api/1.0-SP2/cdi-api-1.0-SP2.jar:/home/jdoe/.m2/repository/org/jboss/spec/javax/interceptor/jboss-interceptors-api_1.1_spec/1.0.0.Beta1/jboss-interceptors-api_1.1_spec-1.0.0.Beta1.jar:/home/jdoe/.m2/repository/javax/annotation/jsr250-api/1.0/jsr250-api-1.0.jar:/home/jdoe/.m2/repository/javax/inject/javax.inject/1/javax.inject-1.jar:/home/jdoe/.m2/repository/org/slf4j/slf4j-api/1.5.10/slf4j-api-1.5.10.jar:/home/jdoe/.m2/repository/org/jboss/weld/weld-core/1.1.0-SNAPSHOT/weld-core-1.1.0-SNAPSHOT.jar:/home/jdoe/.m2/repository/org/jboss/weld/weld-api/1.1-SNAPSHOT/weld-api-1.1-SNAPSHOT.jar:/home/jdoe/.m2/repository/org/jboss/weld/weld-spi/1.1-SNAPSHOT/weld-spi-1.1-SNAPSHOT.jar:/home/jdoe/.m2/repository/com/google/guava/guava/r06/guava-r06.jar:/home/jdoe/.m2/repository/org/jboss/interceptor/jboss-interceptor/1.0.0-CR11/jboss-interceptor-1.0.0-CR11.jar:/home/jdoe/.m2/repository/javassist/javassist/3.11.0.GA/javassist-3.11.0.GA.jar:/home/jdoe/.m2/repository/org/slf4j/slf4j-ext/1.5.10/slf4j-ext-1.5.10.jar:/home/jdoe/.m2/repository/ch/qos/cal10n/cal10n-api/0.7.2/cal10n-api-0.7.2.jar:/home/jdoe/.m2/repository/org/jboss/ejb3/jboss-ejb3-api/3.1.0/jboss-ejb3-api-3.1.0.jar:/home/jdoe/.m2/repository/javax/servlet/servlet-api/2.5/servlet-api-2.5.jar:/home/jdoe/.m2/repository/junit/junit/4.8.1/junit-4.8.1.jar:/home/jdoe/.m2/repository/org/jboss/arquillian/arquillian-junit/1.0.0.Alpha3/arquillian-junit-1.0.0.Alpha3.jar:/home/jdoe/.m2/repository/org/jboss/arquillian/arquillian-impl-base/1.0.0.Alpha3/arquillian-impl-base-1.0.0.Alpha3.jar:/home/jdoe/.m2/repository/org/jboss/arquillian/arquillian-api/1.0.0.Alpha3/arquillian-api-1.0.0.Alpha3.jar:/home/jdoe/.m2/repository/org/jboss/shrinkwrap/shrinkwrap-api/1.0.0-alpha-11/shrinkwrap-api-1.0.0-alpha-11.jar:/home/jdoe/.m2/repository/org/jboss/arquillian/arquillian-spi/1.0.0.Alpha3/arquillian-spi-1.0.0.Alpha3.jar:/home/jdoe/.m2/repository/org/jboss/shrinkwrap/shrinkwrap-impl-base/1.0.0-alpha-11/shrinkwrap-impl-base-1.0.0-alpha-11.jar:/home/jdoe/.m2/repository/org/jboss/shrinkwrap/shrinkwrap-spi/1.0.0-alpha-11/shrinkwrap-spi-1.0.0-alpha-11.jar:/home/jdoe/.m2/repository/javax/el/el-api/2.2/el-api-2.2.jar:/home/jdoe/.m2/repository/el-impl/el-impl/1.0/el-impl-1.0.jar:/home/jdoe/.m2/repository/org/jboss/arquillian/container/arquillian-weld-ee-embedded-1.1/1.0.0.Alpha3/arquillian-weld-ee-embedded-1.1-1.0.0.Alpha3.jar:/home/jdoe/.m2/repository/org/jboss/arquillian/protocol/arquillian-protocol-local/1.0.0.Alpha3/arquillian-protocol-local-1.0.0.Alpha3.jar:/home/jdoe/.m2/repository/org/jboss/arquillian/testenricher/arquillian-testenricher-cdi/1.0.0.Alpha3/arquillian-testenricher-cdi-1.0.0.Alpha3.jar:/home/jdoe/.m2/repository/org/jboss/shrinkwrap/shrinkwrap-extension-classloader/1.0.0-alpha-11/shrinkwrap-extension-classloader-1.0.0-alpha-11.jar:/home/jdoe/.m2/repository/javax/transaction/jta/1.1/jta-1.1.jar:/home/jdoe/.m2/repository/javax/persistence/persistence-api/1.0/persistence-api-1.0.jar:/home/jdoe/.m2/repository/javax/validation/validation-api/1.0.0.GA/validation-api-1.0.0.GA.jar:/home/jdoe/.eclipse/org.eclipse.platform_3.5.0_155965261/configuration/org.eclipse.osgi/bundles/112/1/.cp/:/home/jdoe/.eclipse/org.eclipse.platform_3.5.0_155965261/configuration/org.eclipse.osgi/bundles/110/1/.cp/:/home/jdoe/.eclipse/org.eclipse.platform_3.5.0_155965261/configuration/org.eclipse.osgi/bundles/111/1/.cp/";

        MavenArtifactResolver resolver = new MavenArtifactResolver(groupId, artifactId, classPath, linuxPathSeparator, linuxFileSeparator);
        String path = resolver.resolve();
        assertEquals("/home/jdoe/workspace/extensions/impl/target/seam-solder-api-3.0.1-SNAPSHOT.jar", path);
    }

    @Test
    public void testLinuxInReactorWithDotQualifier() {
        String classPath = "/home/user/workspace/extensions/impl/target/test-classes:/home/jdoe/workspace/extensions/impl/target/classes:/home/jdoe/workspace/extensions/impl/target/seam-solder-api-3.0.1.Final.jar:/home/jdoe/.m2/repository/org/javassist/javassist/3.13.0-GA/javassist-3.13.0-GA.jar:/home/jdoe/.m2/repository/javax/enterprise/cdi-api/1.0-SP2/cdi-api-1.0-SP2.jar:/home/jdoe/.m2/repository/org/jboss/spec/javax/interceptor/jboss-interceptors-api_1.1_spec/1.0.0.Beta1/jboss-interceptors-api_1.1_spec-1.0.0.Beta1.jar:/home/jdoe/.m2/repository/javax/annotation/jsr250-api/1.0/jsr250-api-1.0.jar:/home/jdoe/.m2/repository/javax/inject/javax.inject/1/javax.inject-1.jar:/home/jdoe/.m2/repository/org/slf4j/slf4j-api/1.5.10/slf4j-api-1.5.10.jar:/home/jdoe/.m2/repository/org/jboss/weld/weld-core/1.1.0-SNAPSHOT/weld-core-1.1.0-SNAPSHOT.jar:/home/jdoe/.m2/repository/org/jboss/weld/weld-api/1.1-SNAPSHOT/weld-api-1.1-SNAPSHOT.jar:/home/jdoe/.m2/repository/org/jboss/weld/weld-spi/1.1-SNAPSHOT/weld-spi-1.1-SNAPSHOT.jar:/home/jdoe/.m2/repository/com/google/guava/guava/r06/guava-r06.jar:/home/jdoe/.m2/repository/org/jboss/interceptor/jboss-interceptor/1.0.0-CR11/jboss-interceptor-1.0.0-CR11.jar:/home/jdoe/.m2/repository/javassist/javassist/3.11.0.GA/javassist-3.11.0.GA.jar:/home/jdoe/.m2/repository/org/slf4j/slf4j-ext/1.5.10/slf4j-ext-1.5.10.jar:/home/jdoe/.m2/repository/ch/qos/cal10n/cal10n-api/0.7.2/cal10n-api-0.7.2.jar:/home/jdoe/.m2/repository/org/jboss/ejb3/jboss-ejb3-api/3.1.0/jboss-ejb3-api-3.1.0.jar:/home/jdoe/.m2/repository/javax/servlet/servlet-api/2.5/servlet-api-2.5.jar:/home/jdoe/.m2/repository/junit/junit/4.8.1/junit-4.8.1.jar:/home/jdoe/.m2/repository/org/jboss/arquillian/arquillian-junit/1.0.0.Alpha3/arquillian-junit-1.0.0.Alpha3.jar:/home/jdoe/.m2/repository/org/jboss/arquillian/arquillian-impl-base/1.0.0.Alpha3/arquillian-impl-base-1.0.0.Alpha3.jar:/home/jdoe/.m2/repository/org/jboss/arquillian/arquillian-api/1.0.0.Alpha3/arquillian-api-1.0.0.Alpha3.jar:/home/jdoe/.m2/repository/org/jboss/shrinkwrap/shrinkwrap-api/1.0.0-alpha-11/shrinkwrap-api-1.0.0-alpha-11.jar:/home/jdoe/.m2/repository/org/jboss/arquillian/arquillian-spi/1.0.0.Alpha3/arquillian-spi-1.0.0.Alpha3.jar:/home/jdoe/.m2/repository/org/jboss/shrinkwrap/shrinkwrap-impl-base/1.0.0-alpha-11/shrinkwrap-impl-base-1.0.0-alpha-11.jar:/home/jdoe/.m2/repository/org/jboss/shrinkwrap/shrinkwrap-spi/1.0.0-alpha-11/shrinkwrap-spi-1.0.0-alpha-11.jar:/home/jdoe/.m2/repository/javax/el/el-api/2.2/el-api-2.2.jar:/home/jdoe/.m2/repository/el-impl/el-impl/1.0/el-impl-1.0.jar:/home/jdoe/.m2/repository/org/jboss/arquillian/container/arquillian-weld-ee-embedded-1.1/1.0.0.Alpha3/arquillian-weld-ee-embedded-1.1-1.0.0.Alpha3.jar:/home/jdoe/.m2/repository/org/jboss/arquillian/protocol/arquillian-protocol-local/1.0.0.Alpha3/arquillian-protocol-local-1.0.0.Alpha3.jar:/home/jdoe/.m2/repository/org/jboss/arquillian/testenricher/arquillian-testenricher-cdi/1.0.0.Alpha3/arquillian-testenricher-cdi-1.0.0.Alpha3.jar:/home/jdoe/.m2/repository/org/jboss/shrinkwrap/shrinkwrap-extension-classloader/1.0.0-alpha-11/shrinkwrap-extension-classloader-1.0.0-alpha-11.jar:/home/jdoe/.m2/repository/javax/transaction/jta/1.1/jta-1.1.jar:/home/jdoe/.m2/repository/javax/persistence/persistence-api/1.0/persistence-api-1.0.jar:/home/jdoe/.m2/repository/javax/validation/validation-api/1.0.0.GA/validation-api-1.0.0.GA.jar:/home/jdoe/.eclipse/org.eclipse.platform_3.5.0_155965261/configuration/org.eclipse.osgi/bundles/112/1/.cp/:/home/jdoe/.eclipse/org.eclipse.platform_3.5.0_155965261/configuration/org.eclipse.osgi/bundles/110/1/.cp/:/home/jdoe/.eclipse/org.eclipse.platform_3.5.0_155965261/configuration/org.eclipse.osgi/bundles/111/1/.cp/";

        MavenArtifactResolver resolver = new MavenArtifactResolver(groupId, artifactId, classPath, linuxPathSeparator, linuxFileSeparator);
        String path = resolver.resolve();
        assertEquals("/home/jdoe/workspace/extensions/impl/target/seam-solder-api-3.0.1.Final.jar", path);
    }

}