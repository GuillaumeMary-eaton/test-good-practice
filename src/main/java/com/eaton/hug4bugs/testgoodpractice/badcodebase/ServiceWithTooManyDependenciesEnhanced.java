package com.eaton.hug4bugs.testgoodpractice.badcodebase;

/**
 * Here is a proposition of enhancement of {@link ServiceWithTooManyDependencies} :
 * - methods doing not so much are transformed to a Command pattern
 * - methods doing a bit more or much more are split to some other services
 *
 * Benefits of splitting dependencies are, for example, that you don't need service2, service3 and serviceN to be
 * mocked / stubbed to test {@link DoSomething1CommandHandler#doSomething1()}. Hence you reduce the context of your
 * test, which means less code to be written, and less your brain overload ;)
 */
public class ServiceWithTooManyDependenciesEnhanced {

    public static class DoSomething1CommandHandler {

        private final Repository1 repository1;

        public DoSomething1CommandHandler(Repository1 repository1) {
            this.repository1 = repository1;
        }

        public void doSomething1() {
            // let's have some code that manipulate service1
        }
    }

    public static class DoSomething2CommandHandler {

        private final Repository2 repository2;

        public DoSomething2CommandHandler(Repository2 repository2) {
            this.repository2 = repository2;
        }

        public void doSomething2() {
            // let's have some code that manipulate service2
        }

    }

    public static class DoSomething3Service {

        private final Repository3 repository3;

        public DoSomething3Service(Repository3 repository3) {
            this.repository3 = repository3;
        }

        public void doSomething3_1() {
            // let's have some code that manipulate service3
        }

        public void doSomething3_2() {
            // let's have some code that manipulate service3
        }

    }

    public static class DoManyThingsService {

        private final Repository1 repository1;
        private final Repository2 repository2;
        private final Repository3 repository3;
        private final RepositoryN repositoryN;

        public DoManyThingsService(Repository1 repository1,
                                                      Repository2 repository2,
                                                      Repository3 repository3,
                                                      RepositoryN repositoryN) {
            this.repository1 = repository1;
            this.repository2 = repository2;
            this.repository3 = repository3;
            this.repositoryN = repositoryN;
        }

        public void doManyThings() {
            // let's have some code that manipulate service1, service2, service3, serviceN
        }
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
