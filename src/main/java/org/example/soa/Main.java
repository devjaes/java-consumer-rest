package org.example.soa;

public class Main {
    public static void main(String[] args) {
        StudentApiConsumer studentApiConsumer = new StudentApiConsumer();
//        Student student = new Student("09238423", "Abigail", "Caiza", "Ambato", "0928342");
        /**
         * Get All students
         */
        System.out.println(studentApiConsumer.getAll());

        /**
         * Create a student
         */
//        if (studentApiConsumer.create(student)) {
//            System.out.println("Student created successfully");
//        } else {
//            System.out.println("Failed to create student");
//        }

        /**
         * Update a student
         */
//        Student studentUpdate = new Student("09238423", "Abigail", "Caiza", "Quito", "0928342");
//        if (studentApiConsumer.update(studentUpdate)) {
//            System.out.println("Student updated successfully");
//        } else {
//            System.out.println("Failed to update student");
//        }

        /**
         * Delete a student by its ID(cedula)
         */
//        if (studentApiConsumer.deleteById("04492321231231")) {
//            System.out.println("Student deleted successfully");
//        } else {
//            System.out.println("Failed to delete student");
//        }
    }
}
