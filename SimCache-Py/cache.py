"""
Author: Rueda Cebollero, Guillem
"""

class MemoryCache(object):
	"""
	"""
	_MemBlocks = 2
	_MissesNum = 0
	_MemArray = []
		
	def __init__(self,blocks):
		"""
		"""
		self._MemBlocks = blocks
		self._MemArray = [None for x in range(self._MemBlocks)]
		
	def getMemBlocks(self):
		"""
		"""
		return self._MemBlocks
		
	def getNumMisses(self):
		"""
		"""		
		return self._MissesNum
	
	def resetMisses(self):
		"""
		"""		
		self._MissesNum = 0
		
	def missBlock(self):
		"""
		"""		
		pass
	
	def hitBlock(self):
		"""
		"""
		pass
		
	def access(self,block):
		"""
		"""
		if block in self._MemArray:
			return self.hitBlock(block)
		else:
			return self.missBlock(block)
	
class LRUCache(MemoryCache):
	"""
	"""	
	def missBlock(self,block):
		"""
		"""
		if len(self._MemArray) <= self._MemBlocks-1:
			self._MemArray.append(block)
			
		else:
			self._MemArray.append(block)
			self._MemArray.pop(0)
			
		_MissesNum =+1
		return False
		
	def hitBlock(self,block):
		"""
		"""		
		self._MemArray.remove(block)
		self._MemArray.append(block)
		return True
		

class FIFOCache(MemoryCache):
	"""
	"""	
	def missBlock(self,block):
		"""
		"""		
		if len(self._MemArray) <= self._MemBlocks-1:
			self._MemArray.append(block)
		
		else:
			self._MemArray.append(block)
			self._MemArray.pop(0)
			
		_MissesNum =+1
		return False
		
	def hitBlock(self,block):
		"""
		"""	
		return True

class PLRUCache(MemoryCache):
	"""
	"""
	
	_Tree = []
	
	def _pointingPosition(self):
		
		targetPosition = 0
		path = 0
		
		while (path < self._MemBlocks-1):
			
			if(self._Tree[path] == 0):
				path = 2*path+1
			else:
				path = 2*path+2
					
		targetPosition = path-(self._MemBlocks-1)
		return targetPosition
			
	def _avoidPosition(self,pos):
		
		path = pos + (self._MemBlocks-1)

		while (path > 0):

			parent = (path - 1)/2
			self._Tree[parent] = path%2
			path = parent
			
	def __init__(self,blocks):
		self._MemBlocks = blocks
		self._MemArray = [0 for x in range(self._MemBlocks)]
		self._Tree = [0 for x in range(self._MemBlocks-1)]
		
	def missBlock(self,block):
		
		missPos = self._pointingPosition()
		self._MemArray[missPos] = block
		self._avoidPosition(missPos)
		_MissesNum =+1
		return False
		
	def hitBlock(self,block):

		hitPos = self._MemArray.index(block)
		self._avoidPosition(hitPos)
		return True
	
class MRUCache(MemoryCache):
	"""
	"""
	
	_HelpArray = []
	
	def _isAllVectorOne(self):
		"""
		"""
		vectorStateFull = 0
	
		for item in self._HelpArray:
			if item == 1:
				vectorStateFull+=1
				
		if vectorStateFull == self._MemBlocks:
			self._HelpArray = [0 for x in range(self._MemBlocks)]
		
	
	def __init__(self,blocks):
		"""
		"""
		self._MemBlocks = blocks
		self._MemArray = [0 for x in range(self._MemBlocks)]
		self._HelpArray = [0 for x in range(self._MemBlocks)]
	
	def missBlock(self,block):
		"""
		"""
		for item in range(self._MemBlocks):
			if self._HelpArray[item] == 0:	
				if len(self._MemArray) <= item:
					self._MemArray.append(block)
				else:	
					self._MemArray[item] = block	
				
				self._HelpArray[item] = 1				
				self._isAllVectorOne()
				
				_MissesNum =+1
				return False
		
	def hitBlock(self,block):
		"""
		"""
		for item in range(self._MemBlocks):
			if self._MemArray[item] == block:
				self._HelpArray[item] = 1
				
		return True
		
		

