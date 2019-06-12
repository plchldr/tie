package de.oddcode.alchemist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Set;

@RestController
public class LottoDrawerController {

    @Autowired
    private EntityManager em;

    @RequestMapping(value = "/lottoDrawer/create", method = RequestMethod.POST)
    @Transactional
    public Long create(@RequestParam("balls") int balls, @RequestParam("draws") int draws) {
        var ld = new LottoDrawer(balls,draws);
        em.persist(ld);
        return ld.getId();
    }

    @RequestMapping(value = "/lottoDrawer/{id}")
    @Transactional
    public LottoDrawer show(@PathVariable("id") Long id) {
        return em.find(LottoDrawer.class, id);
    }

    @RequestMapping(value = "/lottoDrawer/{id}/draw",method = RequestMethod.POST)
    @Transactional
    public Set<Integer> draw(@PathVariable("id") Long id) {
        var ld = em.find(LottoDrawer.class, id);
        var result = ld.draw();
        em.merge(ld);
        return result;
    }

}
