package com.example.backadmin.service.facade;

import com.example.backadmin.bean.TableauBesoin;

public interface TableauBesoinService {
    void save(TableauBesoin tableauBesoin);
    TableauBesoin findByReference(String reference);
}
