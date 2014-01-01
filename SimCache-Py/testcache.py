import cache

cache_tests = [
    { 'cache_class': cache.LRUCache,
      'tests': [ 
        { 'size': 4,
          'seq': ['A', 'B', 'C', 'A', 'D', 'E', 'B', 'A'],
          'res': [False, False, False, True, False, False, False, True] },
        { 'size': 7,
          'seq': ['A', 'B', 'C', 'A', 'C', 'B', 'D', 'E', 'F', 'G',
            'F', 'H', 'A', 'B', 'C'],
          'res': [False, False, False, True, True, True, False, False, 
            False, False, True, False, False, True, False] } ]
    },
    { 'cache_class': cache.FIFOCache,
      'tests': [ 
        { 'size': 4,
          'seq': ['A', 'B', 'C', 'A', 'D', 'E', 'B', 'A'],
          'res': [False, False, False, True, False, False, True, False] },
        { 'size': 7,
          'seq': ['A', 'B', 'C', 'A', 'C', 'B', 'D', 'E', 'F', 'G',
            'F', 'H', 'A', 'B', 'C', 'F'],
          'res': [False, False, False, True, True, True, False, False, 
              False, False, True, False, False, False, False, True] } ]
    },
    { 'cache_class': cache.PLRUCache,
      'tests': [ 
        { 'size': 4,
          'seq': ['A', 'B', 'C', 'A', 'D', 'E', 'B', 'A'],
          'res': [False, False, False, True, False, False, True, True] },
        { 'size': 8,
          'seq': ['A', 'B', 'C', 'A', 'C', 'B', 'D', 'E', 'F', 'G',
            'F', 'H', 'A', 'B', 'C', 'F'],
          'res': [False, False, False, True, True, True, False, False, 
             False, False, True, False, True, True, True, True] },
        { 'size': 16,
          'seq': ['A', 'B', 'C', 'A', 'D', 'E', 'B', 'A', 'F', 'A', 'G', 
             'A', 'B', 'H', 'I', 'A', 'C', 'J', 'K', 'L', 'M', 'N', 'O',
             'P', 'X', 'Y', 'A', 'B', 'C', 'D', 'E', 'F'],
          'res': [False, False, False, True, False, False, True, True, 
             False, True, False, True, True, False, False, True, True, 
             False, False, False, False, False, False, False, False, False, 
             True, True, True, False, True, False] } ]
    },
    { 'cache_class': cache.MRUCache,
      'tests': [ 
        { 'size': 4,
          'seq': ['A', 'B', 'C', 'A', 'D', 'E', 'B', 'A'],
          'res': [False, False, False, True, False, False, True, False] },
        { 'size': 7,
          'seq': ['A', 'B', 'C', 'A', 'C', 'B', 'D', 'E', 'F', 'G',
            'F', 'H', 'A', 'B', 'C', 'F'],
          'res': [False, False, False, True, True, True, False, False, 
             False, False, True, False, False, False, False, True] },
        { 'size': 16,
          'seq': ['A', 'B', 'C', 'A', 'D', 'E', 'B', 'A', 'F', 'A', 'G', 
             'A', 'B', 'H', 'I', 'A', 'C', 'J', 'K', 'L', 'M', 'N', 'O',
             'P', 'X', 'Y', 'C', 'A', 'B', 'D', 'E', 'F'],
          'res': [False, False, False, True, False, False, True, True, 
             False, True, False, True, True, False, False, True, True, 
             False, False, False, False, False, False, False, False, False, 
             True, False, False, False, False, False] } ]
    }
]


def run_tests():

    for ct in cache_tests:
        print "Testing cache '%s'." % ct['cache_class'].__name__

        for i, test in enumerate(ct['tests']):
            cclass = ct['cache_class']
            size = test['size']
            c = cclass(size)
            seq = test['seq']
            expected_res = test['res']
            res = [c.access(x) for x in seq]
            del c

            if res == expected_res:
                print "  Test #%d PASSED." % i
            else:
                print "  Test #%d FAILED." % i
                print "    Size: %s" % str(size)
                print "    Sequence: %s" % str(seq)
                print "    Result ....... : %s" % str(res)
                print "    Expected Result: %s" % str(expected_res)
                
                         
run_tests()

# vim:spell:shiftwidth=4:tabstop=4:expandtab:cc=80:
