package de.harshaheg.hack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecordStoreImpl implements RecordStore {

    final List<String> mostUsed = new ArrayList<>(); //Most used at the end
    final Map<String, Record> cache = new HashMap<>();
    final PersistStore persistStore = null;

    @Override
    public Record getRecord(String recordId) {
        Record record;
        boolean cacheHit = false;
        if (cache.containsKey(recordId)) {
            record = cache.get(recordId);
            cacheHit = true;
        } else {
            record = persistStore.getRecord();
        }
        if (record != null) {
            updateAccessCache(recordId, cacheHit);
        }
        return record;
    }

    private void updateAccessCache(String recordId, boolean cacheHit) {
        if(cacheHit){
            //only reorder the list

        }else{
            //Evict the first record
            //Insert this record at the end
        }
    }

    @Override
    public Map<String, Record> getRecords(List<String> recordIds) {
        return null;
    }

    @Override
    public int upsertRecord(Record recordforUpsert) {
        return 0;
    }

    @Override
    public int deleteRecord(String recordId) {
        return 0;
    }
}
