package de.harshaheg.hack;

import java.util.List;
import java.util.Map;

public interface RecordStore {
    /**
     *
     * @param recordId
     * @return the record accessed or null if not found
     */
    Record getRecord(String recordId);
    Map<String, Record> getRecords(List<String> recordIds);
    int upsertRecord(Record recordforUpsert);
    int deleteRecord(String recordId);
}
