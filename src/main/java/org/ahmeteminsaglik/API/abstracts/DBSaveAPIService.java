package org.ahmeteminsaglik.API.abstracts;

import org.ahmeteminsaglik.GetResultService;

import java.util.List;

public interface DBSaveAPIService {
    void save(GetResultService testResult);

    void save(List<GetResultService> testResultList);
}
