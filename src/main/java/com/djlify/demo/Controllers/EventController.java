package com.djlify.demo.Controllers;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = {"http://localhost:63342", "http://localhost:63343"})

public class EventController {

    @GetMapping(path = "Event/getEvent")
    public ArrayList<EventModel> viewAssignments(@RequestParam("ID") int ID)
    {
        ArrayList<AssignmentModel> assignments = new ArrayList<>();
        TokenController.checkToken(token);

        tempStudent = StudentController.getStudent(studentID);
        for (int i = 0; i < tempStudent.getAssignments().size(); i++){
            if (!tempStudent.getAssignments().get(i).isSubmitted()){
                assignments.add(tempStudent.getAssignments().get(i));
            }
        }
        return assignments;

    }

    @RequestMapping(path = "Assignment/newAssignment")
    public boolean createAssignment(@RequestParam("Token") int token, @RequestBody AssignmentModel assignment, @RequestParam("StudentID") int studentID)
    {


        TokenController.checkToken(token);
        tempStudent = StudentController.getStudent(studentID);

        int id = assignment.assignmentID;


        ArrayList <AssignmentModel> assignments = new ArrayList<>();
        assignments = tempStudent.getAssignments();

        for(int i = 0; i < assignments.size(); i++)
        {

            if (assignments.get(i).assignmentID == id)
                return false;
        }


        String name = assignment.name;

        String description = assignment.description;

        int priority = assignment.assignmentPriority;
        String dueDate = assignment.dueDate;

        boolean isSubmitted = false;


        tempAssignment = new AssignmentModel(name, id, description, priority, dueDate, isSubmitted);


        tempStudent = StudentController.getStudent(studentID);
        tempStudent.addAssignment(tempAssignment);

        return true;

    }

    @DeleteMapping(path = "Assignment/submit")
    public void submitAssignment(@RequestParam("Token") int token, @RequestParam("AssignmentID") int assignmentID, @RequestParam("StudentID") int studentID)
    {

        TokenController.checkToken(token);

        tempStudent = StudentController.getStudent(studentID);

        if (tempStudent.getAssignments() == null)
            throw new RuntimeException("Empty Assignment List");

        tempStudent.completeAssignment(assignmentID);

    }

    /**
     * Update an assignment
     * @param assignmentID
     * @param studentID
     * @param assignmentUpdate
     */
    @PutMapping(path = "Assignment/update")
    public boolean updateAssignment(@RequestParam("Token") int token, @RequestParam("AssignmentID") int assignmentID, @RequestParam("StudentID") int studentID,
                                    @RequestBody AssignmentModel assignmentUpdate)
    {

        TokenController.checkToken(token);

        tempStudent = StudentController.getStudent(studentID);
        boolean updatedAssignment = tempStudent.updateAssignment(assignmentID, assignmentUpdate);

        if(updatedAssignment == true)
        {
            return true;
        }
        else
        {
            return false;
        }

}



/**
 * @author David Ewing
 *
 * This is the controller for the AssignmentModel Class
 */



