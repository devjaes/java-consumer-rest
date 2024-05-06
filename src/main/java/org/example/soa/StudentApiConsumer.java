package org.example.soa;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class StudentApiConsumer implements CrudRepository<Student> {
    private final String URL = "http://localhost/QuintoSt/Controllers/apiEstudiantes.php";

    /**
     * Get a student by its ID<Cedula>, (url not implemented in the backend service)
     *
     * @param ID the ID of the student
     * @return the student with the given ID
     */
    @Override
    public Student getById(String ID) {
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.URL)
                .queryParam("cedula", ID);
        ResponseEntity<Student> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, Student.class);
        return responseEntity.getBody();
    }

    /**
     * Get all students
     *
     * @return a list of all students
     */
    @Override
    public List<Student> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        Student[] students = restTemplate.getForObject(this.URL, Student[].class);
        return students != null ? Arrays.asList(students) : Collections.emptyList();
    }

    /**
     * Create a student
     *
     * @param student the student to create
     * @return true if the student was created successfully, false otherwise
     */
    @Override
    public boolean create(Student student) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Student> requestEntity = new HttpEntity<>(student);
        ResponseEntity<Void> responseEntity = restTemplate.exchange(this.URL, HttpMethod.POST, requestEntity, Void.class);

        return responseEntity.getStatusCode() == HttpStatus.OK;
    }

    /**
     * Update a student
     *
     * @param student the student to update
     * @return true if the student was updated successfully, false otherwise
     */
    @Override
    public boolean update(Student student) {
        RestTemplate restTemplate = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.URL)
                .queryParam("cedula", student.getID())
                .queryParam("nombre", student.getFirstName())
                .queryParam("apellido", student.getLastName())
                .queryParam("direccion", student.getAddress())
                .queryParam("telefono", student.getPhone());

        String updateUrl = builder.toUriString();

        ResponseEntity<Void> responseEntity = restTemplate.exchange(updateUrl, HttpMethod.PUT, null, Void.class);

        return responseEntity.getStatusCode() == HttpStatus.OK;
    }


    /**
     * Delete a student by its ID(cedula)
     *
     * @param ID the ID of the student to delete
     * @return true if the student was deleted successfully, false otherwise
     */
    @Override
    public boolean deleteById(String ID) {
        RestTemplate restTemplate = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.URL)
                .queryParam("cedula", ID);

        String deleteUrl = builder.toUriString();

        ResponseEntity<Void> responseEntity = restTemplate.exchange(deleteUrl, HttpMethod.DELETE, null, Void.class);
        return responseEntity.getStatusCode() == HttpStatus.OK;
    }
}