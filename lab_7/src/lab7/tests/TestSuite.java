package lab7.tests;

import lab7.tests.BookstoreTest;
import lab7.tests.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(value = Suite.class)
@Suite.SuiteClasses(value = {BookstoreTest.class, SellerTest.class})
class _testRunner {

}