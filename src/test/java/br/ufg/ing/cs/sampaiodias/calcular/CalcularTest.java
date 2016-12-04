/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.ing.cs.sampaiodias.calcular;

import br.ufg.inf.cs.sampaiodias.calcular.Calcular;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author lucas
 */
public class CalcularTest {

    @Test
    public void calcular2soma2() {
        String[] test = {"2", "+", "2"};
        assertEquals("4.0", Calcular.executarParser(test));
    }

    @Test
    public void calcular9div3() {
        String[] test = {"9", "/", "3"};
        assertEquals("3.0", Calcular.executarParser(test));
    }

    @Test
    public void calcularA() {
        String[] test = {"A"};
        assertEquals("0.0", Calcular.executarParser(test));
    }

    @Test
    public void calcularExpressaoParentesesSomaMult() {
        String[] test = {"(", "2", "+", "2", ")", "*", "3"};
        assertEquals("12.0", Calcular.executarParser(test));
    }

    @Test
    public void calcularExpressaoParentesesIncognitas() {
        String[] test = {"(", "x", "+", "y", ")", "*", "a"};
        assertEquals("0.0", Calcular.executarParser(test));
    }

    @Test
    public void calcularExpressaoIncognitaE() {
        String[] test = {"aaa", "&", "bbb"};
        assertEquals("0.0", Calcular.executarParser(test));
    }

    @Test
    public void calcularExpressaoIncognitaOU() {
        String[] test = {"aaa", "|", "bbb"};
        assertEquals("0.0", Calcular.executarParser(test));
    }

    @Test(expected = IllegalArgumentException.class)
    public void calcularDoisOperadoresSemParenteses() {
        String[] test = {"3", "+", "2", "*", "4"};
        Calcular.executarParser(test);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calcularApenasOperador() {
        String[] test = {"+"};
        Calcular.executarParser(test);
    }

    @Test
    public void tratarArgs1() {
        String[] test = {"1"};
        Assert.assertArrayEquals(test, Calcular.tratarArgs(test));
    }

    @Test
    public void tratarArgsVazia() {
        String[] test = new String[]{};
        Assert.assertArrayEquals(new String[]{"ERROR ARGS"},
                Calcular.tratarArgs(test));
    }

    @Test
    public void tratarArgsHelp() {
        String[] test = new String[]{"help"};
        Assert.assertArrayEquals(new String[]{"ERROR ARGS"},
                Calcular.tratarArgs(test));
    }

    @Test
    public void tratarArgsH() {
        String[] test = new String[]{"-h"};
        Assert.assertArrayEquals(new String[]{"ERROR ARGS"},
                Calcular.tratarArgs(test));
    }
}
