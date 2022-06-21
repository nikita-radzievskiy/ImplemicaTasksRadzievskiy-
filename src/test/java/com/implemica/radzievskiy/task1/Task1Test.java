package com.implemica.radzievskiy.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class Task1Test {

    @Test
    void shouldReturn14VariantsWithBracketWithInput4WhenCallsMethodGenerateParens() {
        //given
        int count = 4;
        //when
        ArrayList<String> list = Task1.generateParens(count);
        //then
        Assertions.assertEquals(14, list.size());
    }

    @Test
    void shouldReturn5VariantsWithBracketWithInput3WhenCallsMethodGenerateParens() {
        //given
        int count = 3;
        //when
        ArrayList<String> list = Task1.generateParens(count);
        //then
        Assertions.assertEquals(5, list.size());
    }

    @Test
    void shouldReturn2VariantsWithBracketWithInput2WhenCallsMethodGenerateParens() {
        //given
        int count = 2;
        //when
        ArrayList<String> list = Task1.generateParens(count);
        //then
        Assertions.assertEquals(2, list.size());
    }

}
