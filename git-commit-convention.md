#### Format of the commit message:

```
<type>(<scope>): <subject>
<body>
```

#### Message subject (first line)

First line cannot be longer than 70 characters, second line is always blank and other lines should be wrapped at 80 characters. The type and scope should always be lowercase as shown below.
Allowed `<type>` values:
* add (new algorithm was added)
* fix (bug fix or implementation fix)
* feat (new feature to an existing algorithm, add methods or interfaces)
* docs (changes to the documentation)
* chore (changes in the project structure or build scripts)
* test (adding test cases, refactoring tests)
* style (formatting and styling)

#### `<scope>` values

Are equal to the corresponding package name

* datastructures
* graphs
* math
* search
* sorts

or file

* gradle
* readme

or vcs

* git

#### `<body>` parameter is optional
