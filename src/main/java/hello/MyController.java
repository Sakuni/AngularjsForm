package hello;

import hello.dto.UserDTO;
import hello.dto.FormInfoDTO;
import hello.model.Form;
import hello.model.User;
import hello.repository.FormRepository;
import hello.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by Sakuni.Manamendra on 10/20/2016.
 */
@RestController
public class MyController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FormRepository formRepository;

// Get example
    @RequestMapping(value = "/myMarks",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> getMarks() {
        return new ResponseEntity<>(500, HttpStatus.OK);
    }

//    Post example
    @RequestMapping(value = "/postMarks",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> postMarks(@Valid @RequestBody Integer data) {
        // can include any logic here to data
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

//    DTO example
    @RequestMapping(value = "/saveUser",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> postMarks(@Valid @RequestBody UserDTO userDTO) {
        //Save user to db
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());

        User savedUser = userRepository.save(user);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    // Form example
    @RequestMapping(value = "/saveData",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FormInfoDTO> postMarks(@Valid @RequestBody FormInfoDTO formInfoDTO) {
        //Save form data to db
        Form form = new Form();
        form.setId(formInfoDTO.getId());
        form.setName(formInfoDTO.getName());
        form.setEmail(formInfoDTO.getEmail());
        form.setPassword(formInfoDTO.getPassword());

        Form savedData = formRepository.save(form);

        return new ResponseEntity<>(formInfoDTO, HttpStatus.OK);
    }
}
