package com.github.mperry

import groovy.transform.CompileStatic
import groovy.transform.TypeChecked
import org.junit.Test

import rx.Observable

/**
 * Created by MarkPerry on 26/04/2014.
 */
@TypeChecked
//@CompileStatic
class Test1 {

    @Test
    void test1() {
        Observable.from(["mark", "perry"]).subscribe({ println("item: $it") })
    }

}
