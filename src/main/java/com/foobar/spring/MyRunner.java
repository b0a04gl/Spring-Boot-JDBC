package com.foobar.spring;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.foobar.spring.model.Store;
import com.foobar.spring.dao.StoreDaoRepository;
/*
 * private int store_id;
	private String store_name;
	private String phone;
	private String email;
	private String street;
	private String city;
	private String state;
	private String zip_code;
 */

@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private StoreDaoRepository storeRepository;

    @Override
    public void run(String...args) throws Exception {

    			//Create operation
    	
    	logger.info("records being inserted");
    	storeRepository.save(new Store( "RelianceFresh", "9878123421","relianceFresh@hotmail.com","Dravid Street","Chennai","Tamil Nadu","600025"));
    	storeRepository.save(new Store( "LazzyShop", "8123987421","thelazyshop@gmail.com","Rajaji Street","Chennai","Tamil Nadu","600025"));
    	storeRepository.save(new Store( "CoolBiz", "7234219881","coolbiz@hotmail.com","Kotturpuram Street","Chennai","Tamil Nadu","600025"));
    	
    	
    	logger.info("No of Stores: "+ storeRepository.count());

        
        		//Read operation
    	logger.info("Stores detail");

        Iterable < Store > stores = storeRepository.findAll();
        Iterator < Store > iterator = stores.iterator();
        while (iterator.hasNext()) {
            logger.info("{ "+ iterator.next().toString() + " }");
        }

               //Update operation
        Optional<Store> temp = storeRepository.findById(14);
        Store storeToBeUpdated = temp.get();
        
        logger.info("Store to be updated : "+storeToBeUpdated.toString());
        storeToBeUpdated.setEmail("newEmail@gmail.com");
        
        storeRepository.save(storeToBeUpdated);
        
        
                //delete operation
        logger.info("Deleting record with store_id 11");
        storeRepository.deleteById(11);
        
        
//        storeRepository.existsById(2);

    }
}
