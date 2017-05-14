package Model;

import java.util.ArrayList;

/**
 * PearPlanner
 * Created by Team BRONZE on 4/27/17
 */
public class Coursework extends Assignment
{
    private Event startDate;
    private Deadline deadline;
    private ArrayList<Extension> extensions;

    // private methods
    @Override
    protected void replace(VersionControlEntity receivedVCE)
    {
        if (receivedVCE instanceof Coursework)
        {
            Coursework castedVCE = (Coursework) receivedVCE;
            this.startDate = castedVCE.getStartDate();
            this.deadline = castedVCE.getDeadline();
            this.extensions = castedVCE.getExtensions();
        }

        super.replace(receivedVCE);
    }
    // public methods

    // getters
    public Event getStartDate()
    {
        return startDate;
    }

    public Deadline getDeadline()
    {
        return deadline;
    }

    public ArrayList<Extension> getExtensions()
    {
        return extensions;
    }

    public ArrayList<Note> getNotes()
    {
        return notes;
    }


    // setters
    public void addNote(Note newNote)
    {
        if (!notes.contains(newNote))
        {
            notes.add(newNote);
        }
    }

    public void removeNote(Note oldNote)
    {
        if (notes.contains(oldNote))
        {
            notes.remove(oldNote);
        }
    }

    // Constructors
    public Coursework(int cWeighting, Person cSetBy, Person cMarkedBy, Person cReviewedBy, int cMarks, Event cStartDate,
                      Deadline cDeadline, ArrayList<Extension> cExtensions)
    {
        super(cWeighting, cSetBy, cMarkedBy, cReviewedBy, cMarks);
        startDate = cStartDate;
        deadline = cDeadline;
        extensions = (ArrayList<Extension>) cExtensions.clone();
    }

}
