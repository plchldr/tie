package de.oddcode.alchemist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoinTosserController {

    @RequestMapping("/tossCoin")
    public CoinTosser.Result tossCoin() {
        return new CoinTosser().tossCoin();
    }
}
