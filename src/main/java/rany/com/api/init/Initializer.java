package rany.com.api.init;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Initializer {

    private final RoleInitializer roleInitializer;

    private final UserInitializer userInitializer;

    private final CategoryInitializer categoryInitializer;

    private final ProductInitializer productInitializer;

    private final OrderInitializer orderInitializer;

    @PostConstruct
    public void  init(){

        roleInitializer.initRoles();
//        userInitializer.initUsers();
        categoryInitializer.initCategories();
        productInitializer.initProducts();
//        orderInitializer.initOrders();

    }
}
