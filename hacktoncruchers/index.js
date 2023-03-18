const Web3 = require("web3");
const truffleContract = require("@truffle/contract");
const express = require("express");
const bodyParser = require("body-parser");
const cors = require("cors");

// Connect to Ganache
const web3 = new Web3(new Web3.providers.HttpProvider("http://127.0.0.1:7545"));

// Get the JSON representation of the compiled contract
const storageJSON = require("./build/contracts/Storage.json");

// Create a contract abstraction
const Storage = truffleContract(storageJSON);
Storage.setProvider(web3.currentProvider);

const app = express();
app.use(cors()); // Enable CORS with a wildcard origin
app.use(bodyParser.json());

app.post("/store", async (req, res) => {

    try {
        const accounts = await web3.eth.getAccounts();
        const storageInstance = await Storage.deployed();

        const { userId, diseaseReport, doctorName, hospitalName } = req.body;
        await storageInstance.set(userId, diseaseReport, doctorName, hospitalName, { from: accounts[0] });

        res.status(200).json({ message: "Data stored successfully." });
    } catch (error) {
        console.error(error);
        res.status(500).json({ message: "An error occurred while storing data." });
    }
});

app.get("/get/:userId", async (req, res) => {
    try {
        const storageInstance = await Storage.deployed();

        const specificUserId = parseInt(req.params.userId);
        const storedDataArray = await storageInstance.getAll.call(specificUserId);

        const records = storedDataArray.map((record) => ({
            diseaseReport: record.diseaseReport,
            doctorName: record.doctorName,
            hospitalName: record.hospitalName,
        }));

        res.status(200).json({ userId: specificUserId, records });
    } catch (error) {
        console.error(error);
        res.status(500).json({ message: "An error occurred while retrieving data." });
    }
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
});
