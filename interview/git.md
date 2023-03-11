### Commands

# Undo last commit
```
git reset HEAD~ 
```

# Reset on develop
```
git reset --hard origin/develop
```

# Rebase
```
git rebase -i master
```

# Branch 
Delete command
Locally:
```
git branch -D feat/A
```
Remotely:
```
git push -d origin feat/A
```

### GitFlow

From master start develop branch.
```
git checkout -b develop
```
From develop create feature branches:
```
git checkout -b feature/A 

change smth and then:
git add .
git commit -m "Add new feature"
git push origin feature/A 
```
Merge branch into develop:
```
git checkout develop
git merge --no-ff feature/A
```
Make release from develop:
```
git checkout -b release/v1.0.0

make release changes and then:
git add .
git commit -m "Release v1.0.0"
git push origin release/v1.0.0
```
Merge release into master and develop
```
git checkout master
git merge --no-ff release/v1.0.0
git push
git tag v1.0.0
git push origin v1.0.0

git checkout develop
git merge --no-ff release/v1.0.0
git push
```

# Case with hotfix
From master branch:
```
git checkout -b hotfix/v1.0.1

make hotfix changes and then:
git add .
git commit -m "Hotfix v1.0.1"
git push origin hotfix/v1.0.1
```

Merge hotfix into master and develop:
```
git checkout master
git merge --no-ff hotfix/v1.0.1
git push
git tag v1.0.1
git push origin v1.0.1

git checkout develop
git merge --no-ff hotfix/v1.0.1
git push
```

NOTE: `--no-ff` option in git merge forces git to create a merge commit to represent the merge.
This preserves history of branches and makes it easier to understand.
Otherwise, git fast forwards(hence `ff`) history of the base branch(ex develop) to the last commit in the
merged branch. It looks as if you were adding commits directly in develop branch and pushing them directly.
