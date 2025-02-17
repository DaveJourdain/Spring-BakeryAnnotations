public class Bakercontrollerjava {import com.zipcodewilmington.bakery.models.Baker;
import com.zipcodewilmington.bakery.services.BakerService;
//import jdk.internal.vm.annotation.Contended;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

    @RestController
    public class BakerController {
        @Autowired
        private BakerService service;

        public BakerController(BakerService service) {
            this.service = service;
        }

        @GetMapping(value = "/baker")
        public ResponseEntity<Iterable<Baker>> index() {
            return new ResponseEntity<>(service.index(), HttpStatus.OK);
        }
//
        public ResponseEntity<Baker> show(Long id) {
            @GetMapping(value = "/baker/{id}")
            public ResponseEntity<Baker> show(@PathVariable Long id) {
                return new ResponseEntity<>(service.show(id), HttpStatus.OK);
            }

            public ResponseEntity<Baker> create(Baker baker) {
                @PostMapping(value = "/baker")
                public ResponseEntity<Baker> create(@RequestBody Baker baker) {
                    return new ResponseEntity<>(service.create(baker), HttpStatus.CREATED);
                }

                public ResponseEntity<Baker> update(Long id, Baker baker) {
                    @PutMapping(value = "/baker/{id}")
                    public ResponseEntity<Baker> update(@PathVariable Long id, @RequestBody Baker baker) {
                        return new ResponseEntity<>(service.update(id, baker), HttpStatus.OK);
                    }

                    public ResponseEntity<Boolean> destroy(Long id) {
                        @DeleteMapping(value = "/baker/{id}")
                        public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
                            return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
                        }
                    }




}
