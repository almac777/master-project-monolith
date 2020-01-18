# master-project-monolith
monolith solution for my master project

# goal

goal is to allow rating of articles and newspapers by users.

## users

users must be able to
* register
* login
* logout
* "unregister"

## articles

* list
* show exactly one
* create a new article

## rating

* create new rating for an article and a user
* ratings implemented
* todo: implement batch job

## testing

* improve testcases
* implement accumulated rating testcase
* implement AccumulatedRatingServiceTest and RatingServiceTest
* implement HTTP calls for the controllers
* implement integration test for the controllers
* write a gatling test

## todo

* implement algorithm to extract url
* implement possibility to register news agency providers
** only by e.g. moderators
* implement possibility to register owners of the news agency
** only by e.g. moderators
* implement possibility to register author of an article (optional)
* when unregistering, the ratings should not change, so ratings should be transfered to a locked user

## use cases

* it should be possible to "register" new users
** a user should be viewable, their ratings though, not
* it should be possible to delete a user
** only a user should be able to delete themselves
* it should be possible to "report" articles
** articles should be rateable
*** articles rating should be accumulated
** articles should be viewable
* think of more metrics
