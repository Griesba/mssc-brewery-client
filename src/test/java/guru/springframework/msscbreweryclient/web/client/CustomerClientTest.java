package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient client;

    @Test
    void getCustomer() {
        CustomerDto customerDto = client.getCustomer(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void testCreateCustomer() {
        CustomerDto customerDto = client.creatCustomer(CustomerDto.builder().build());
        assertNotNull(customerDto);
    }

    @Test
    void testUpdateCustomer() {
        client.updateCustomer(UUID.randomUUID(), CustomerDto.builder().build());
    }

    @Test
    void testDeleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}