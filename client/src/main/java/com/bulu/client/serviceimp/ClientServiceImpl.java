package com.bulu.client.serviceimp;

import com.bulu.client.service.ClientService;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Override
    public String getMessage(String name) throws Exception {
        return "hello".concat(" ").concat(name);
    }
}
