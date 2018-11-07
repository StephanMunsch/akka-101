package de.fla.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import de.fla.akka.dt.Pair;
import de.fla.akka.dt.Pairs;
import de.fla.akka.dt.Script;

import java.io.IOException;

public class ActorSystem101 {

    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("101-aktoren-lerngrupppe");

        Script script = new Script("Programming 3",
                new Pairs.Builder<Integer, String>()
                        .and(Pair.of(1, "Classes, Interfaces, Reflection, Inner Class, Attribute, Association"))
                        .and(Pair.of(2, "Functional Programming, Unary Predicate, Binary Function, Higher Order Function"))
                        .and(Pair.of(3, "No idea about what we learnt"))
                        .and(Pair.of(4, "No idea about what we learnt"))
                        .and(Pair.of(5, "Components, Interfaces, Configuration, Packet structure, View on Components"))
                        .and(Pair.of(6, "Intelligent Datatypes, Entities, Enumerations"))
                        .and(Pair.of(7, "Application Development, Software Components, Entity Types, Coupling (loose, tight), Data Access Layer"))
                        .and(Pair.of(8, "Errors and Exceptions, Normal vs. abnormal, Safety Facade, Logging"))
                        .and(Pair.of(9, "Aspect oriented programming, Aspect, Pointcut, Join Point, Weaving, Compile Time"))
                        .and(Pair.of(10, "Threads, Synchronization, Communication between Threads, Producer Consumer Problem, Thread"))
                        .build());
        try {

            final ActorRef scriptSplitter = system.actorOf(ScriptSplitter.props(), "ScriptSplitter");
            scriptSplitter.tell(script, ActorRef.noSender());

            System.out.println(">>> Press ENTER to exit <<<");
            System.in.read();
        } catch (IOException ignored) {
        } finally {
            system.terminate();
        }
    }
}
