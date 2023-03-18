pragma solidity ^0.8.0;

contract Storage {
    struct Record {
        string diseaseReport;
        string doctorName;
        string hospitalName;
    }

    mapping(uint256 => Record[]) private records;

    function set(
        uint256 userId,
        string calldata diseaseReport,
        string calldata doctorName,
        string calldata hospitalName
    ) public {
        records[userId].push(Record(diseaseReport, doctorName, hospitalName));
    }

    function get(uint256 userId, uint256 index)
    public
    view
    returns (
        string memory diseaseReport,
        string memory doctorName,
        string memory hospitalName
    )
    {
        Record storage record = records[userId][index];
        return (
        record.diseaseReport,
        record.doctorName,
        record.hospitalName
        );
    }

    function getAll(uint256 userId)
    public
    view
    returns (Record[] memory)
    {
        return records[userId];
    }
}
