package Algo2019.Graphs.BipartiteGraph;

public class MaximumBipartiteMatching {

    static class Graph {
        int jobs;
        int applicants;
        int adjMatrix[][];

        public Graph(int applicants, int jobs) {
            this.jobs = jobs;
            this.applicants = applicants;
            adjMatrix = new int[applicants][jobs];
        }

        public void canDoJob(int applicant, int job) {
            //add edge - means applicant can do this job
            adjMatrix[applicant][job] = 1;
        }
    }

    public int maxMatching(Graph graph) {
        int applicants = graph.applicants;
        int jobs = graph.jobs;

        int assign[] = new int[jobs];    //an array to track which job is assigned to which applicant
        for (int i = 0; i < jobs; i++)
            assign[i] = -1;    //initially set all jobs are available
        int jobCount = 0;

        for (int applicant = 0; applicant < applicants; applicant++) {    //for all applicants
            //for each applicant, all jobs will be not visited initially
            boolean visited[] = new boolean[jobs];

            //check if applicant can get a job
            if (bipartiteMatch(graph, applicant, visited, assign)) {
                //if yes then increase the job count
                jobCount++;
            }
        }
        return jobCount;
    }

    boolean bipartiteMatch(Graph graph, int applicant, boolean visited[], int assign[]) {
        //check each job for the applicant
        for (int job = 0; job < graph.jobs; job++) {
            //check if applicant can do this job means adjMatrix[applicant][job] == 1
            // and applicant has not considered for this job before, means visited[job]==false
            if (graph.adjMatrix[applicant][job] == 1 && !visited[job]) {
                //mark as job is visited, means applicant is considered for this job
                visited[job] = true;
                //now check if job was not assigned earlier - assign it to this applicant
                // OR job was assigned earlier to some other applicant 'X' earlier then
                //make recursive call for applicant 'X' to check if some other job can be assigned
                // so that this job can be assigned to current candidate.
                int assignedApplicant = assign[job];
                if (assignedApplicant < 0 || bipartiteMatch(graph, assignedApplicant, visited, assign)) {
                    assign[job] = applicant;    //assign job job to applicant applicant
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //Construct Graph with applicants and jobs
        int applicants = 6;
        int jobs = 6;
        Graph graph = new Graph(applicants, jobs);
        graph.canDoJob(0, 0);
        graph.canDoJob(0, 1);
        graph.canDoJob(0, 2);
        graph.canDoJob(1, 0);
        graph.canDoJob(2, 1);
        graph.canDoJob(3, 4);
        graph.canDoJob(4, 3);
        graph.canDoJob(4, 4);
        graph.canDoJob(5, 5);

        MaximumBipartiteMatching m = new MaximumBipartiteMatching();
        System.out.println("Maximum number of applicants that could" +
                " get jobs are: " + m.maxMatching(graph));
    }
}
