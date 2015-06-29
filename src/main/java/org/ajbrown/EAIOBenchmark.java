package org.ajbrown;

import com.eaio.uuid.UUID;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * @author A.J. Brown <aj@ajbrown.org>
 */
@State(Scope.Thread)
@Warmup(iterations = 1, batchSize = 1000)
@Measurement(iterations = 10, batchSize = 100000 )
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class EAIOBenchmark {

    @Benchmark
    public UUID timeAndEthernetBased() {
        return new UUID();
    }
}
