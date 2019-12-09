class Task:
    def __init__(self, description, team):
        self.description = description
        self.team = team

    # create the method
    def __add__(self, other):
        description = self.description + '\n' + other.description
        team = self.team + ', ' + other.team
        return Task(description, team)


task1 = Task("Finish the assignment.", "Kate")
task2 = Task("Prepare the project for class.", "James, Ann")

task3 = task1 + task2
# "Finish the assignment.\nPrepare the project for class."
print(task3.description)
print(task3.team)  # "Kate, James, Ann"
