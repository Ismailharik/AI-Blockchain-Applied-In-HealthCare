package com.enset.modelaiservice.services;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.tensorflow.SavedModelBundle;
import org.tensorflow.Tensor;

import java.util.List;

@Service
public class ModelService {
    private final String modelPath = "C:/Users/pc/Documents/Mes_Projets/model-ai-service/src/main/resources/model.h5";
    private SavedModelBundle model;

    @PostConstruct
    public void init() {
        try {
            model = SavedModelBundle.load(modelPath, "serve");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public float predict(float[] input) {
        float[][] inputArray = new float[1][input.length];
        inputArray[0] = input;

        Tensor<Float> inputTensor = Tensor.create(inputArray, Float.class);
        List<Tensor<?>> output = model.session().runner().feed("input_1", inputTensor).fetch("dense_1/Softmax").run();

        float[] outputArray = output.get(0).copyTo(new float[1][2])[0];
        return outputArray[1];
    }
}

