package com.example.backadmin.service.facade;

import com.example.backadmin.bean.TableauBesoin;

public interface TableauBesoinService {
    TableauBesoin findByReference(String reference);

    int save(TableauBesoin tableauBesoin);
}
