/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fileupload;

import javax.ejb.Local;
import org.tensorflow.Tensor;

/**
 *
 * @author Korisnik
 */
@Local
public interface RecognitionLocal {
    float[] executeInceptionGraph();
}
