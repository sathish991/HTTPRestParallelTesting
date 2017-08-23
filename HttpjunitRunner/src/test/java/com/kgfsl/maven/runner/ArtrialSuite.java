package com.kgfsl.maven.runner;

/**
 * @author Sathishkanna.s
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import com.kgfsl.testclasses.*;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	ArtrailTestLinks.class,
	AutoAllocationScreen.class
})
public class ArtrialSuite {

}
