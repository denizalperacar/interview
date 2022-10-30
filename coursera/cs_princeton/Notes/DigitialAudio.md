# Notes on Digitial Audio

- A pure tone is a sinusoidal waveform
- pitch A is 440 Hz 
- Other 12 notes are spaced by $440 \times 2^{i/12}$
- 12'th note is again A with an octave higher
- A wave is sampled uniformly generally 44100 samples per second is used.

## API of the StdAudio

* void play(String file)
* void play(double[] a)
* void play(double x) 
* void save(String file, double[] a)
* double[] read(String file)

```java
... {
    public static double[] tone(double hz, double duration) {
        int N = (int) (duration * 44100);
        double[] sound = new double[N+1];
        for (int i = 0; i <= N; i++) {
            sound[i] = Math.sin(2 * math.PI * hz * i / 44100);
        }
        return sound;
    }
}
```

So the A is basically `tone(440, duration)` for the note duration.

```java
... {
    public static double[] pitch(int note, double duration) {
        return tone(440 * Math.pow(2, note / 12.0), duration);
    }
}
```


