from flask import Flask, request, jsonify
import json
import numpy as np
from keras.models import load_model
from flask_cors import CORS
app = Flask(__name__)
CORS(app, resources={r"*": {"origins": "*"}})


# Charger le modèle h5
model = load_model('./model.h5')

@app.route('/predict', methods=['POST'])
def predict():
    input_data = request.get_json(force=True)
    features = np.array(input_data['features']).reshape(1, -1)  # Remplacez cette ligne par la transformation des données nécessaire pour votre modèle
    prediction = model.predict(features)
    return jsonify(prediction.tolist())

if __name__ == '__main__':
    app.run(debug=True, port=5000)