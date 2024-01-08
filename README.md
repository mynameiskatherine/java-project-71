# Differ - console json/yml comparing tool

## Description
Console json/yml comparing tool. Compares two json/yml files and shows the difference in three different formats:
- a simple "+" or "-";
- text description of changes;
- a json format with an array of available values from two files.

NOTE: The difference is printed only for the first level of files' structures. Nested structures shown "as is".
(Training project)

## Usage
Simple:
```sh
gendiff file1.json file2.json
```
Detailed:
```sh
Usage: gendiff [-hV] [-f=<format>] filePath1 filePath2
Compares two configuration files and shows a difference.
      filePath1           path to first file
      filePath2           path to second file
  -f, --format=<format>   output format [default: stylish]
  -h, --help              Show this help message and exit.
  -V, --version           Print version information and exit.
```

## Demo of working
https://asciinema.org/a/3APYS2TR7DWDahAZyzrcnudej

## Hexlet tests and linter status:
[![Actions Status](https://github.com/mynameiskatherine/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/mynameiskatherine/java-project-71/actions)
[![Gradle build status](https://github.com/mynameiskatherine/java-project-71/actions/workflows/gradle.yml/badge.svg)](https://github.com/mynameiskatherine/java-project-71/actions)
### CodeClimate code maintainability and test coverage status:
[![Maintainability](https://api.codeclimate.com/v1/badges/8acb0ede6668b8edb805/maintainability)](https://codeclimate.com/github/mynameiskatherine/java-project-71/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/8acb0ede6668b8edb805/test_coverage)](https://codeclimate.com/github/mynameiskatherine/java-project-71/test_coverage)
