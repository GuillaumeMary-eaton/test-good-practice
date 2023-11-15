package com.eaton.hug4bugs.testgoodpractice.badcodebase;

/**
 * This is an example of a class, let's say a service, that has too many dependencies on some other services. Typical
 * case is those dependencies are repositories.
 * @see ServiceWithTooManyDependenciesEnhanced
 */
public class ServiceWithTooManyDependencies {

    private final Repository1 repository1;
    private final Repository2 repository2;
    private final Repository3 repository3;
    private final RepositoryN repositoryN;

    public ServiceWithTooManyDependencies(Repository1 repository1,
                                          Repository2 repository2,
                                          Repository3 repository3,
                                          RepositoryN repositoryN) {
        this.repository1 = repository1;
        this.repository2 = repository2;
        this.repository3 = repository3;
        this.repositoryN = repositoryN;
    }

    public void doSomething1() {
        // let's have some code that manipulate service1
    }

    public void doSomething2() {
        // let's have some code that manipulate service2
    }

    public void doSomething3_1() {
        // let's have some code that manipulate service3
    }

    public void doSomething3_2() {
        // let's have some code that manipulate service3
    }

    public void doManyThings() {
        // let's have some code that manipulate service1, service2, service3, serviceN
    }


    /* Those interfaces should be outside this class, they are here only to avoid exposing it in package which may
     * confuse people while they first arrive in this repo.
     */
    public interface Repository1 {

    }

    public interface Repository2 {

    }

    public interface Repository3 {

    }

    public interface RepositoryN {

    }
}
