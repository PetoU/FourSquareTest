package com.kris.whitbread.api.service;

import retrofit.RequestInterceptor;

public final class ApiHeaders implements RequestInterceptor {

    private static final String HEADER_CLIENT_ID = "client_id";
    private static final String HEADER_CLIENT_SECRET = "client_secret";
    private static final String HEADER_VERSION = "v";

    private static final String CLIENT_ID = "MCJROZXRKKQX5NZZQUASBAYG2TT2SMGW0MAARAY3MDSPFXBR";
    private static final String CLIENT_SECRET = "CTU1IVHRBVCPM3EP4E2AEQSTJPR22ZHE0RZ1O4SG1QFQ4MDF";
    private static final String VERSION = "20130815";

    @Override
    public void intercept(RequestFacade request) {

        request.addHeader(HEADER_CLIENT_ID, CLIENT_ID);
        request.addHeader(HEADER_CLIENT_SECRET, CLIENT_SECRET);
        request.addHeader(HEADER_VERSION, VERSION);

    }
}