package org.ajbrown;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.NameBasedGenerator;
import com.fasterxml.uuid.impl.RandomBasedGenerator;
import com.fasterxml.uuid.impl.TimeBasedGenerator;
import org.openjdk.jmh.annotations.*;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author A.J. Brown <aj@ajbrown.org>
 */
@State(Scope.Thread)
@Warmup(iterations = 1, batchSize = 1000)
@Measurement(iterations = 10, batchSize = 100000 )
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class JUGBenchmark {

    private byte[] namespace;

    private NameBasedGenerator nameBasedGenerator;
    private TimeBasedGenerator timeBasedGenerator;
    private TimeBasedGenerator timeAndEthernetBasedGenerator;
    private RandomBasedGenerator randomBasedGenerator;

    @Setup
    public void setUp() {
        namespace = "org.ajbrown".getBytes();

        nameBasedGenerator = Generators.nameBasedGenerator();
        timeBasedGenerator = Generators.timeBasedGenerator();
        timeAndEthernetBasedGenerator = Generators.timeBasedGenerator( EthernetAddress.fromInterface() );
        randomBasedGenerator = Generators.randomBasedGenerator();
    }

    @Benchmark
    public UUID nameBased() {
        return nameBasedGenerator.generate( namespace );
    }

    @Benchmark
    public UUID timeBased() {
        return timeBasedGenerator.generate();
    }

    @Benchmark
    public UUID timeAndEthernetBased() {
        return timeAndEthernetBasedGenerator.generate();
    }

    @Benchmark
    public UUID random() {
        return randomBasedGenerator.generate();
    }
}
