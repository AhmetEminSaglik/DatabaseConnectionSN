package org.ahmeteminsaglik.API.abstracts;


import org.ahmeteminsaglik.abstracts.get.api.GetTestResultService;

import java.util.List;

public interface DBSaveAPIService {
    void save(GetTestResultService resultService);
    void save(List<GetTestResultService> resultServiceList);
}
